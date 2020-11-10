package runners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import Simple.Se.GlobalVars;
import Simple.Se.Functions.utilityFunctions;
import io.cucumber.core.gherkin.FeatureParserException;
import io.cucumber.core.gherkin.vintage.GherkinVintageFeatureParser;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import toolbox.JSON.JSONTools_Properties;

@SuppressWarnings("restriction")
public class SSeGui extends Application {
	Threading task;
	GridPane grid;
	Scene scene;

	TextField featureFileLoc;
	Button BuildVars_button;
	Button Stop_button;
	File featureFolder;
	TextField testDataLoc;
	File dataFolder;
	TextField objMapLoc;
	TextField credentialsLoc;
	TextField executionInfo;
	File objectMapFile;
	File credentialsFile;
	static String[] args1;
	utilityFunctions utility;

	public static void main(String[] args) {
		args1 = args;
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			utilityFunctions utility = new utilityFunctions();
			utility.clearLog();
			utility.writeToLog("Loaded Poperties");
			setGrid();
			GlobalVars.properties = new JSONTools_Properties();
			GlobalVars.properties.init();
			
			if(args1.length >0) {
				utility.deleteTempFolders();
				GlobalVars.properties.saveJSON();
				utility.createMFolders();
				
				try {
					Threading task = new Threading();  
					task.setOnRunning((succeesesEvent) -> {
						executionInfo.setText("Automation Started");
					});
			
					String[] fileTypes= {"lastFeatureFolder","lastDataFolder","lastObjectMap","lastCredentialsFile"};
					for(int i=0;i<args1.length;i++) {
						if(!args1[i].isEmpty()) {
							switch(fileTypes[i]){
							case "lastFeatureFolder": utility.featureFiles = args1[i];
							break;
							case "lastDataFolder": GlobalVars.dataFiles = args1[i];
							break;
							case "lastObjectMap": GlobalVars.objMapFile = args1[i];
							break;
							case "lastCredentialsFile": GlobalVars.credentialsFile = args1[i];
							break;
							}
							GlobalVars.properties.setAttribute(fileTypes[i], args1[i]);
						}
					}
					//fields
					featureFileLoc = new TextField();
					testDataLoc = new TextField();
					objMapLoc = new TextField();
					credentialsLoc = new TextField();
					executionInfo = new TextField();
					
					//Actons
					featureFileLoc.setText(GlobalVars.properties.getValue("lastFeatureFolder"));
					testDataLoc.setText(GlobalVars.properties.getValue("lastDataFolder"));
					objMapLoc.setText(GlobalVars.properties.getValue("lastObjectMap"));
					credentialsLoc.setText(GlobalVars.properties.getValue("lastCredentialsFile"));
					
					File directory = new File(utility.featureFiles);
					File fileList[] = directory.listFiles();
					for(File file:fileList) {
						if(file.getName().toLowerCase().endsWith(".feature"))
							validateFeatures(file);
					}
					GlobalVars.properties.saveJSON();

					utility.createTempFolders();
					System.setProperty("cucumber.options", utility.tfeatureFiles);
					utility.writeToLog("Loaded Cucumber Options");
					GlobalVars.featureParsed = false;
					ExecutorService executorService
					= Executors.newFixedThreadPool(1);
					executorService.execute(task);
					executorService.shutdown();
					if(!GlobalVars.featureParsed) {
						utility.writeToLog("Feature File formatting is incorrect!");
					}
				} catch (NumberFormatException e2) {

				}
			}else {
				//labels
				Label featureFile_lbl = new Label("Select Feature Files Folder:");
				Text scenetitle = new Text("Load Files:");
				//Label testData_lbl = new Label("Select Data Files Folder:");
				//Label objMap_lbl = new Label("Select Object Map File:");
				//Label credentials_lbl = new Label("Select Credentials File:");

				//fields
				featureFileLoc = new TextField();
				testDataLoc = new TextField();
				objMapLoc = new TextField();
				credentialsLoc = new TextField();
				executionInfo = new TextField();
				
				//Actons
				featureFileLoc.setText(GlobalVars.properties.getValue("lastFeatureFolder"));
				testDataLoc.setText(GlobalVars.properties.getValue("lastDataFolder"));
				objMapLoc.setText(GlobalVars.properties.getValue("lastObjectMap"));
				credentialsLoc.setText(GlobalVars.properties.getValue("lastCredentialsFile"));

				//buttons
				BuildVars_button = new Button("Run Files");
				Stop_button = new Button("Stop");
				Button SelectfeatureFolder_button = new Button("Select");
				//Button SelectTestDataFolder_button = new Button("Select");
				//Button SelectObjMapFile_button = new Button("Select");
				//Button SelectCredentialsFile_button = new Button("Select");

				//button Initialized
				BuildVars_button.setDisable(true);
				Stop_button.setDisable(true);

				//Fonts
				scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 14));
				int fieldlength = 80;
				int row= 0;
				int col=0;
				//grid locations
				grid.add(scenetitle                   , col, row);
				grid.add(featureFile_lbl              , col, row+1);
				grid.add(featureFileLoc               , col, row+1, fieldlength-1,1);
				grid.add(BuildVars_button             , col+10, row+4 , 10, 1);
				grid.add(Stop_button                  , col+30, row+4 , 10, 1);
				grid.add(SelectfeatureFolder_button   , fieldlength, row+1);
				//grid.add(testData_lbl                 , 0, 3);
				//grid.add(testDataLoc                  , 0, 4, fieldlength-1, 1);
				//grid.add(SelectTestDataFolder_button  , fieldlength, 4);
				//grid.add(objMap_lbl                   , 0, 5);
				//grid.add(objMapLoc                    , 0, 6, fieldlength-1, 1);
				//grid.add(SelectObjMapFile_button      , fieldlength, 6);
				//grid.add(credentials_lbl              , 0, 7);
				//grid.add(credentialsLoc               , 0, 8, fieldlength-1, 1);
				//grid.add(SelectCredentialsFile_button , fieldlength, 8);
				grid.add(executionInfo                , 1, 8, 45, 10);

				//File Choosers
				DirectoryChooser directoryChooser = new DirectoryChooser();
				FileChooser fileChooser = new FileChooser();

				//filters
				FileChooser.ExtensionFilter xlsxFilter = new FileChooser.ExtensionFilter("JSON files", "*.json");
				fileChooser.getExtensionFilters().add(xlsxFilter);

				SelectfeatureFolder_button.setOnAction(e -> {
					featureFolder = directoryChooser.showDialog(primaryStage);
					if(featureFolder != null) {
						featureFileLoc.setText(featureFolder.getAbsolutePath());
						GlobalVars.properties.setAttribute("lastFeatureFolder", featureFileLoc.getText());
						allowRun();
					}
				});
				//			SelectTestDataFolder_button.setOnAction(e -> {
				//				dataFolder = directoryChooser.showDialog(primaryStage);
				//				if(dataFolder != null) {
				//					testDataLoc.setText(dataFolder.getAbsolutePath());
				//					GlobalVars.properties.setAttribute("lastDataFolder", testDataLoc.getText());
				//					allowRun();
				//				}
				//			});
				//			SelectObjMapFile_button.setOnAction(e -> {
				//				objectMapFile = fileChooser.showOpenDialog(primaryStage);
				//				if(objectMapFile != null) {
				//					objMapLoc.setText(objectMapFile.getAbsolutePath());
				//					GlobalVars.properties.setAttribute("lastObjectMap", objMapLoc.getText());
				//					allowRun();
				//				}
				//			});
				//			SelectCredentialsFile_button.setOnAction(e -> {
				//				credentialsFile = fileChooser.showOpenDialog(primaryStage);
				//				if(credentialsFile != null) {
				//					credentialsLoc.setText(credentialsFile.getAbsolutePath());
				//					GlobalVars.credentialsFile = credentialsLoc.getText();
				//					GlobalVars.properties.setAttribute("lastCredentialsFile", credentialsLoc.getText());
				//					allowRun();
				//				}
				//			});
				primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					public void handle(WindowEvent we) {
						System.exit(0);
					}
				});

				BuildVars_button.setOnAction(e -> {
					utility.deleteTempFolders();
					GlobalVars.properties.saveJSON();
					Stop_button.setDisable(false);
					utility.createMFolders();
					utility.featureFiles = featureFileLoc.getText();
					File directory = new File(utility.featureFiles);
					File fileList[] = directory.listFiles();
					for(File file:fileList) {
						if(file.getName().toLowerCase().endsWith(".feature"))
							validateFeatures(file);
					}

					GlobalVars.dataFiles = testDataLoc.getText();
					GlobalVars.objMapFile = objMapLoc.getText();
					GlobalVars.objectMapFile = objMapLoc.getText();
					GlobalVars.credentialsFile = credentialsLoc.getText();
					utility.createTempFolders();
					System.setProperty("cucumber.options", utility.tfeatureFiles);
					utility.writeToLog("Loaded Cucumber Options");
					GlobalVars.featureParsed = false;

					try {
						Threading task = new Threading();  
						task.setOnRunning((succeesesEvent) -> {
							executionInfo.setText("Automation Started");
						});

						ExecutorService executorService
						= Executors.newFixedThreadPool(1);
						executorService.execute(task);
						executorService.shutdown();
						if(!GlobalVars.featureParsed) {
							utility.writeToLog("Feature File formatting is incorrect!");
						}
					} catch (NumberFormatException e2) {

					}
				});
				Stop_button.setOnAction(e -> {
					RunCukesTest.endAlll();
					System.exit(0);
				});
				allowRun();
				setStage(primaryStage);
			}
		}catch(Exception e) {
			executionInfo.setText("Error Occured!: " + e);
			utility.writeToLog(e.getMessage());
		}
	}

	public void setStage(Stage primaryStage) {
		primaryStage.setScene(scene);
		primaryStage.setTitle("Test Case Runner");
		primaryStage.show();
	}

	public void setGrid() {
		grid = new GridPane();
		scene = new Scene(grid, 650, 200);
		grid.setAlignment(Pos.TOP_LEFT);
		grid.setHgap(5);
		grid.setVgap(5);
		grid.setPadding(new Insets(5, 5, 5, 10));
	}

	public void validateFeatures(File file) {
		GherkinVintageFeatureParser parser = new GherkinVintageFeatureParser();
		try {
			parser.parse(file.toURI(), new String(Files.readAllBytes(file.toPath())), null);
		} catch (IOException e) {
			e.printStackTrace();
		}catch (FeatureParserException fp) {
			utility.writeToLog(fp.getMessage());
			String lineNumbers = fp.getCause().toString();
			lineNumbers = lineNumbers.substring(lineNumbers.indexOf("(")+1, lineNumbers.indexOf(")"));
			utility.writeToLog("Error Found on line number " + lineNumbers);
		}
	}

	public void allowRun() {
		if(featureFileLoc.getText() != null && testDataLoc.getText() != null && objMapLoc.getText() != null) {
			BuildVars_button.setDisable(false);
		}
	}
}