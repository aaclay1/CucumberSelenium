package stepdefinitions;

import java.io.IOException;

import com.aventstack.extentreports.gherkin.model.Feature;
import com.mongodb.assertions.Assertions;

import Simple.Se.GlobalVars;
import Simple.Se.Functions.PORTAL;
import Simple.Se.Functions.UCI;
import Simple.Se.Functions.behavioralFunctions;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import toolbox.JSON.JSONTool_ObjectElements;

public class NYC311_StepDefs extends GlobalVars {
	behavioralFunctions GUI = new behavioralFunctions();

	//OTFA - Start ******************************************//

	@Given("I navigate to {string}")
	public void i_navigate_to(String string){
		GUI.launchURL(string);
	}

	@And("I enter into input field {string} the value {string}")
	public void I_enter_into_input_field_the_value(String string, String string2) throws Throwable{
		GUI.setText(string, string2);
	}

	@And("I click on {string} button")
	public void I_click_on_button(String string) throws Throwable{
		GUI.clickButton(string);
	}

	@Then("{string} should be present")
	public void should_be_present(String string) throws Throwable{
		GUI.objectExists(string);
	}

	@And("I capture screenshot")
	public void I_capture_screenshot() throws Throwable{
		takeScreenCapture=true;
	}

	@And("I should see page title as {string}")
	public void i_should_see_page_title_as() throws Throwable{

	}

	@And("I should not see page title as {string}")
	public void i_should_not_see_page_title_as() throws Throwable{

	}

	@And("I should see page title having partial text as {string}")
	public void i_should_see_page_title_having_partial_text_as() throws Throwable{

	}

	@And("I should not see page title having partial text as {string}")
	public void i_should_not_see_page_title_having_partial_text_as() throws Throwable{

	}

	@And("Link having text {string} should be present")
	public void link_having_text_should_be_present() throws Throwable{

	}

	@And("Link having partial text {string} should be present")
	public void link_having_partial_text_should_be_present() throws Throwable{

	}

	@And("Link having text {string} should not be present")
	public void link_having_text_should_not_be_present() throws Throwable{

	}

	@And("Link having partial text {string} should not be present")
	public void link_having_partial_text_should_not_be_present() throws Throwable{

	}

	@And("{string} should have text as {string}")
	public void should_have_text_as() throws Throwable{

	}

	@And("{string} should have partial text as {string}")
	public void should_have_partial_text_as() throws Throwable{

	}

	@And("{string} should not have text as {string}")
	public void should_not_have_text_as() throws Throwable{

	}

	@And("{string} should not have partial text as {string}")
	public void should_not_have_partial_text_as() throws Throwable{

	}

	@And("{string} should contain text")
	public void should_contain_text() throws Throwable{

	}

	@And("{string} should be enabled")
	public void should_be_enabled() throws Throwable{

	}

	@And("{string} should be disabled")
	public void should_be_disabled() throws Throwable{

	}

	@And("{string} should not be present")
	public void should_not_be_present() throws Throwable{

	}

	@And("{string} checkbox should be checked")
	public void checkbox_should_be_checked() throws Throwable{

	}

	@And("{string} checkbox should be unchecked")
	public void checkbox_should_be_unchecked() throws Throwable{

	}

	@And("{string} dropdown should be selected with the value {string}")
	public void dropdown_should_be_selected_with_the_value() throws Throwable{

	}

	@And("{string} dropdown should not be selected with the value {string}")
	public void dropdown_should_not_be_selected_with_the_value() throws Throwable{

	}

	@And("{string} option is selected from {string}")
	public void option_is_selected_from() throws Throwable{

	}

	@And("{string} option is unselected from {string}")
	public void option_is_unselected_from() throws Throwable{

	}

	@And("I should see alert text as {string}")
	public void i_should_see_alert_text_as() throws Throwable{

	}

	@And("{string}redx should be present in the table row that contains {string}")
	public void redx_should_be_present_in_the_table_row_that_contains() throws Throwable{

	}

	@And("{string} dropdown should not have the value {string}")
	public void dropdown_should_not_have_the_value() throws Throwable{

	}

	@And("{string} should contain one value of {string}")
	public void should_contain_one_value_of() throws Throwable{

	}

	@And("{string} should match the regular expression {string}")
	public void should_match_the_regular_expression() throws Throwable{

	}

	@And("I extract from canvas value that starts with {string} to match with {string}")
	public void i_extract_from_canvas_value_that_starts_with_to_match_with() throws Throwable{

	}

	@And("I validate each product element text and count {string} with the values from {string}")
	public void i_validate_each_product_element_text_and_count_with_the_values_from() throws Throwable{

	}

	@And("I validate element {string} with the lower range {string} and upper range {string}")
	public void i_validate_element_with_the_lower_range_and_upper_range() throws Throwable{

	}

	@And("I validate each product element text {string} with the values from {string}")
	public void i_validate_each_product_element_text_with_the_values_from() throws Throwable{

	}

	@And("I validate each product element partial text {string} with the values from {string}")
	public void i_validate_each_product_element_partial_text_with_the_values_from() throws Throwable{

	}

	@And("I enable to ignore numbers and special characters in text validation")
	public void i_enable_to_ignore_numbers_and_special_characters_in_text_validation() throws Throwable{

	}

	@And("I disable to ignore numbers and special chararters in text validation")
	public void i_disable_to_ignore_numbers_and_special_chararters_in_text_validation() throws Throwable{

	}

	@And("I enable web services automation")
	public void i_enable_web_services_automation() throws Throwable{

	}

	@And("I disable web services automation")
	public void i_disable_web_services_automation() throws Throwable{

	}

	/*@And("I run custom code {string} with arguments || ||")
	public void i_run_custom_code_with_arguments_||_||() throws Throwable{

	}

	@And("I capture return value as {string} from python script {string} run with arguments || ||")
	public void i_capture_return_value_as_from_python_script_run_with_arguments_||_||() throws Throwable{

	}

	@And("I capture return value as {string} from custom code {string} run with arguments || ||")
	public void i_capture_return_value_as_from_custom_code_run_with_arguments_||_||() throws Throwable{

	}

	@And("I run python script {string} with arguments || ||")
	public void i_run_python_script_with_arguments_||_||() throws Throwable{

	}
	 */
	@And("I run function {string}")
	public void i_run_function() throws Throwable{

	}

	@And("I group steps into function as {string}")
	public void i_group_steps_into_function_as() throws Throwable{

	}

	@And("I end function")
	public void i_end_function() throws Throwable{

	}

	@And("I upload to {string} the file {string}")
	public void i_upload_to_the_file() throws Throwable{

	}

	@And("I download file from {string}")
	public void i_download_file_from() throws Throwable{

	}

	@And("I transfer server file {string} to remote location {string} using linux connection {string}")
	public void i_transfer_server_file_to_remote_location_using_linux_connection() throws Throwable{

	}

	@And("I transfer remote file {string} to server location {string} using linux connection {string}")
	public void i_transfer_remote_file_to_server_location_using_linux_connection() throws Throwable{

	}

	@And("I extract files from directory {string} using connection {string}")
	public void i_extract_files_from_directory_using_connection() throws Throwable{

	}

	@And("I extract file name {string} as variable {string} for field {string} using rule {string}")
	public void i_extract_file_name_as_variable_for_field_using_rule() throws Throwable{

	}

	@And("I validate input source {string} against file extracted value {string}")
	public void i_validate_input_source_against_file_extracted_value() throws Throwable{

	}

	@And("I extract file name that starts with {string} as variable {string} for field {string} using rule {string}")
	public void i_extract_file_name_that_starts_with_as_variable_for_field_using_rule() throws Throwable{

	}

	@And("I set header property {string} with value {string}")
	public void i_set_header_property_with_value() throws Throwable{

	}

	@And("I set request from data file as {string}")
	public void i_set_request_from_data_file_as() throws Throwable{

	}

	@And("I declare soap service with method {string}")
	public void i_declare_soap_service_with_method() throws Throwable{

	}

	@And("I switch to wsdlurl {string}")
	public void i_switch_to_wsdlurl() throws Throwable{

	}

	@And("I switch to endpoint {string}")
	public void i_switch_to_endpoint() throws Throwable{

	}

	@And("I set request as {string}")
	public void i_set_request_as() throws Throwable{

	}

	@And("I set request object at xpath {string} with value {string}")
	public void i_set_request_object_at_xpath_with_value() throws Throwable{

	}

	@And("I validate response property {string} count less than {string}")
	public void i_validate_response_property_count_less_than() throws Throwable{

	}

	@And("I validate response status code with value {string}")
	public void i_validate_response_status_code_with_value() throws Throwable{

	}

	@And("I validate response present")
	public void i_validate_response_present() throws Throwable{
		GUI.api_GET();
	}

	@And("I validate response not present")
	public void i_validate_response_not_present() throws Throwable{

	}

	@And("I validate response contains the value {string}")
	public void i_validate_response_contains_the_value() throws Throwable{

	}

	@And("I validate response time less than {string} in milliseconds")
	public void i_validate_response_time_less_than_in_milliseconds() throws Throwable{

	}

	@And("I validate response from json object having name {string}")
	public void i_validate_response_from_json_object_having_name() throws Throwable{

	}

	@And("I validate response property {string} is equal to value {string}")
	public void i_validate_response_property_is_equal_to_value() throws Throwable{

	}

	@And("I validate response property {string} is equal to boolean value {string}")
	public void i_validate_response_property_is_equal_to_boolean_value() throws Throwable{

	}

	@And("I validate response property {string} is not equal to value {string}")
	public void i_validate_response_property_is_not_equal_to_value() throws Throwable{

	}

	@And("I validate response property {string} value greater than {string}")
	public void i_validate_response_property_value_greater_than() throws Throwable{

	}

	@And("I validate response property {string} value less than {string}")
	public void i_validate_response_property_value_less_than() throws Throwable{

	}

	@And("I validate response property {string} contains value {string}")
	public void i_validate_response_property_contains_value() throws Throwable{

	}

	@And("I validate response property {string} present")
	public void i_validate_response_property_present() throws Throwable{

	}

	@And("I validate response property {string} count is equal to {string}")
	public void i_validate_response_property_count_is_equal_to() throws Throwable{

	}

	@And("I validate response property {string} count is not equal to {string}")
	public void i_validate_response_property_count_is_not_equal_to() throws Throwable{

	}

	@And("I validate response property {string} count greater than {string}")
	public void i_validate_response_property_count_greater_than() throws Throwable{

	}

	@And("I validate response property {string} has children")
	public void i_validate_response_property_has_children() throws Throwable{

	}

	@And("I validate response property {string} with value match regular expression {string}")
	public void i_validate_response_property_with_value_match_regular_expression() throws Throwable{

	}

	@And("I validate response header property {string} with value {string}")
	public void i_validate_response_header_property_with_value() throws Throwable{

	}

	@And("I validate response property {string} is equal to double value {string}")
	public void i_validate_response_property_is_equal_to_double_value() throws Throwable{

	}

	@And("I validate response property {string} is equal to long value {string}")
	public void i_validate_response_property_is_equal_to_long_value() throws Throwable{

	}

	@And("I validate response property {string} is equal to int value {string}")
	public void i_validate_response_property_is_equal_to_int_value() throws Throwable{

	}

	@And("I validate response json object as {string} from data file")
	public void i_validate_response_json_object_as_from_data_file() throws Throwable{

	}

	@And("I validate response header has the property {string}")
	public void i_validate_response_header_has_the_property() throws Throwable{

	}

	@And("I validate response header property {string} is equal to value {string}")
	public void i_validate_response_header_property_is_equal_to_value() throws Throwable{

	}

	@And("I validate response header property {string} is equal to boolean value {string}")
	public void i_validate_response_header_property_is_equal_to_boolean_value() throws Throwable{

	}

	@And("I validate response header property {string} is equal to int value {string}")
	public void i_validate_response_header_property_is_equal_to_int_value() throws Throwable{

	}

	@And("I validate response header property {string} is equal to double value {string}")
	public void i_validate_response_header_property_is_equal_to_double_value() throws Throwable{

	}

	@And("I validate response header property {string} is equal to long value {string}")
	public void i_validate_response_header_property_is_equal_to_long_value() throws Throwable{

	}

	@And("I validate response header property {string} is not equal to value {string}")
	public void i_validate_response_header_property_is_not_equal_to_value() throws Throwable{

	}

	@And("I validate response header property {string} is greater than value {string}")
	public void i_validate_response_header_property_is_greater_than_value() throws Throwable{

	}

	@And("I validate response header property {string} is less than value {string}")
	public void i_validate_response_header_property_is_less_than_value() throws Throwable{

	}

	@And("I validate response header property {string} with value match regular expression {string}")
	public void i_validate_response_header_property_with_value_match_regular_expression() throws Throwable{

	}

	@And("I validate count of response property {string} having value {string} is equal to {string}")
	public void i_validate_count_of_response_property_having_value_is_equal_to() throws Throwable{

	}

	@And("I validate count of response property {string} having value {string} is greater than {string}")
	public void i_validate_count_of_response_property_having_value_is_greater_than() throws Throwable{

	}

	@And("I validate count of response property {string} having value {string} is less than {string}")
	public void i_validate_count_of_response_property_having_value_is_less_than() throws Throwable{

	}

	@And("I validate count of response property {string} having value {string} is not equal to {string}")
	public void i_validate_count_of_response_property_having_value_is_not_equal_to() throws Throwable{

	}

	@And("I validate value {string} contains response property {string}")
	public void i_validate_value_contains_response_property() throws Throwable{

	}

	@And("I switch to new window")
	public void i_switch_to_new_window() throws Throwable{

	}

	@And("I navigate forward")
	public void i_navigate_forward() throws Throwable{

	}

	@And("I navigate backward")
	public void i_navigate_backward() throws Throwable{

	}

	@And("I refresh page")
	public void i_refresh_page() throws Throwable{

	}

	@And("I switch to previous window")
	public void i_switch_to_previous_window() throws Throwable{

	}

	@And("I switch to window having title {string}")
	public void i_switch_to_window_having_title() throws Throwable{

	}

	@And("I close new window")
	public void i_close_new_window() throws Throwable{

	}

	@And("I switch to main window")
	public void i_switch_to_main_window() throws Throwable{

	}

	@And("I resize browser window size to width {string} and height {string}")
	public void i_resize_browser_window_size_to_width_and_height() throws Throwable{

	}

	@And("I maximize browser window")
	public void i_maximize_browser_window() throws Throwable{

	}

	@And("I scroll to top of page")
	public void i_scroll_to_top_of_page() throws Throwable{

	}

	@And("I scroll to end of page")
	public void i_scroll_to_end_of_page() throws Throwable{

	}

	@And("I scroll to element {string}")
	public void i_scroll_to_element() throws Throwable{

	}

	@And("I close browser")
	public void i_close_browser() throws Throwable{

	}

	@And("I switch to default frame")
	public void i_switch_to_default_frame() throws Throwable{

	}

	@And("I allow to continue to the website")
	public void i_allow_to_continue_to_the_website() throws Throwable{

	}

	@And("I open new window with {string}")
	public void i_open_new_window_with() throws Throwable{

	}

	@And("I do not switch to any new window")
	public void i_do_not_switch_to_any_new_window() throws Throwable{

	}

	@And("I scroll to end of {string}")
	public void i_scroll_to_end_of() throws Throwable{

	}

	@And("I enable scroll to view")
	public void i_enable_scroll_to_view() throws Throwable{

	}

	@And("I disable scroll to view")
	public void i_disable_scroll_to_view() throws Throwable{

	}

	@And("I switch to frame having id or name {string}")
	public void i_switch_to_frame_having_id_or_name() throws Throwable{

	}

	@And("I switch to frame having xpath {string}")
	public void i_switch_to_frame_having_xpath() throws Throwable{

	}

	@And("I switch to frame having index {string}")
	public void i_switch_to_frame_having_index() throws Throwable{

	}

	@And("I click on {string} link")
	public void i_click_on_link() throws Throwable{

	}

	@And("I double click on {string} button")
	public void i_double_click_on_button() throws Throwable{

	}

	@And("I drag from {string} and drop to {string}")
	public void i_drag_from_and_drop_to() throws Throwable{

	}

	@And("I right click on {string} and select {string}")
	public void i_right_click_on_and_select() throws Throwable{

	}

	@And("I mouse hover on {string}")
	public void i_mouse_hover_on() throws Throwable{

	}

	@And("I click {string} of the table row which contains {string}")
	public void i_click_of_the_table_row_which_contains() throws Throwable{

	}

	@And("I click on dynamic element {string} link")
	public void i_click_on_dynamic_element_link() throws Throwable{

	}

	@And("I press enter key on {string}")
	public void i_press_enter_key_on() throws Throwable{

	}

	@And("I press tab key on {string}")
	public void i_press_tab_key_on() throws Throwable{

	}

	@And("I click on single key{string}")
	public void i_click_on_single_key() throws Throwable{

	}

	@And("I click on two key combination with modifier key {string} and non modifier key {string}")
	public void i_click_on_two_key_combination_with_modifier_key_and_non_modifier_key() throws Throwable{

	}

	@And("I accept alert")
	public void i_accept_alert() throws Throwable{

	}

	@And("I dismiss alert")
	public void i_dismiss_alert() throws Throwable{

	}

	@And("I execute JS command {string}")
	public void i_execute_js_command() throws Throwable{

	}

	@And("I accept alert if present")
	public void i_accept_alert_if_present() throws Throwable{

	}

	@And("I dismiss alert if present")
	public void i_dismiss_alert_if_present() throws Throwable{

	}

	@And("I execute JS command {string} on object {string}")
	public void i_execute_js_command_on_object() throws Throwable{

	}

	@And("I check if response property {string} is present")
	public void i_check_if_response_property_is_present() throws Throwable{

	}

	@And("I check if response property {string} has value {string}")
	public void i_check_if_response_property_has_value() throws Throwable{

	}

	@And("I check else if response property {string} has value {string}")
	public void i_check_else_if_response_property_has_value() throws Throwable{

	}

	@And("I check else if response property {string} is present")
	public void i_check_else_if_response_property_is_present() throws Throwable{

	}

	@And("I check and do API else condition")
	public void i_check_and_do_api_else_condition() throws Throwable{

	}

	@And("I end API conditional check")
	public void i_end_api_conditional_check() throws Throwable{

	}

	@And("I loop if response property {string} has value {string}")
	public void i_loop_if_response_property_has_value() throws Throwable{

	}

	@And("I loop if response property {string} is not present")
	public void i_loop_if_response_property_is_not_present() throws Throwable{

	}

	@And("I loop if response property {string} is present")
	public void i_loop_if_response_property_is_present() throws Throwable{

	}

	@And("I end API loop")
	public void i_end_api_loop() throws Throwable{

	}

	@And("I drag slider {string} right by pixels {string}")
	public void i_drag_slider_right_by_pixels() throws Throwable{

	}

	@And("I drag slider {string} left by pixels {string}")
	public void i_drag_slider_left_by_pixels() throws Throwable{

	}

	@And("I drag slider {string} above by pixels {string}")
	public void i_drag_slider_above_by_pixels() throws Throwable{

	}

	@And("I drag slider {string} down by pixels {string}")
	public void i_drag_slider_down_by_pixels() throws Throwable{

	}

	@And("I capture visible screen")
	public void i_capture_visible_screen() throws Throwable{

	}

	@And("I take screenshot")
	public void i_take_screenshot() throws Throwable{
		takeScreenCapture=true;
	}

	@And("I enable full page screenshot")
	public void i_enable_full_page_screenshot() throws Throwable{

	}

	@And("I disable full page screenshot")
	public void i_disable_full_page_screenshot() throws Throwable{

	}

	@And("I search for OTP in mail {string} and store in otp variable {string}")
	public void i_search_for_otp_in_mail_and_store_in_otp_variable() throws Throwable{

	}

	@And("I search for OTP in sms for mobile user {string} and store in otp variable {string}")
	public void i_search_for_otp_in_sms_for_mobile_user_and_store_in_otp_variable() throws Throwable{

	}

	@And("I enter into otp field {string} the otp variable {string}")
	public void i_enter_into_otp_field_the_otp_variable() throws Throwable{

	}

	@And("I unselect multiple values from dropdown {string}")
	public void i_unselect_multiple_values_from_dropdown() throws Throwable{

	}

	@And("I uncheck the checkbox {string}")
	public void i_uncheck_the_checkbox() throws Throwable{

	}

	@And("I toggle the checkbox {string}")
	public void i_toggle_the_checkbox() throws Throwable{

	}

	@And("I select radio {string} with the option {string}")
	public void i_select_radio_with_the_option() throws Throwable{

	}

	@And("I add wait seconds of {string}")
	public void i_add_wait_seconds_of() throws Throwable{

	}

	@And("I enter into date field {string} the value {string}")
	public void i_enter_into_date_field_the_value() throws Throwable{

	}

	@And("I capture element {string} as variable")
	public void i_capture_element_as_variable() throws Throwable{

	}

	@And("I capture xml element value {string} of {string} as variable")
	public void i_capture_xml_element_value_of_as_variable() throws Throwable{

	}

	@And("I select from list {string} the value {string}")
	public void i_select_from_list_the_value() throws Throwable{

	}

	@And("I select from list {string} the partial value {string}")
	public void i_select_from_list_the_partial_value() throws Throwable{

	}

	@And("I unselect from list {string} the value {string}")
	public void i_unselect_from_list_the_value() throws Throwable{

	}

	@And("I unselect from list {string} the partial value {string}")
	public void i_unselect_from_list_the_partial_value() throws Throwable{

	}

	@And("I select from list {string} multiple partial values")
	public void i_select_from_list_multiple_partial_values() throws Throwable{

	}

	@And("I unselect from list {string} multiple partial values")
	public void i_unselect_from_list_multiple_partial_values() throws Throwable{

	}

	@And("I select from list {string} multiple values")
	public void i_select_from_list_multiple_values() throws Throwable{

	}

	@And("I unselect from list {string} multiple values")
	public void i_unselect_from_list_multiple_values() throws Throwable{

	}

	@And("I select multiple values from dropdown {string}")
	public void i_select_multiple_values_from_dropdown() throws Throwable{

	}

	@And("I select from autosuggest option field {string} the value {string}")
	public void i_select_from_autosuggest_option_field_the_value() throws Throwable{

	}

	@And("I enter into input field {string} the value {string} and search")
	public void i_enter_into_input_field_the_value_and_search() throws Throwable{

	}

	@And("I clear the content of input field {string}")
	public void i_clear_the_content_of_input_field() throws Throwable{

	}

	@And("I select from dropdown {string} the value {string}")
	public void i_select_from_dropdown_the_value() throws Throwable{

	}

	@And("I select from dropdown {string} the item {string}")
	public void i_select_from_dropdown_the_item() throws Throwable{

	}

	@And("I select all options from dropdown {string}")
	public void i_select_all_options_from_dropdown() throws Throwable{

	}

	@And("I unselect all options from dropdown {string}")
	public void i_unselect_all_options_from_dropdown() throws Throwable{

	}

	@And("I check the checkbox {string}")
	public void i_check_the_checkbox() throws Throwable{

	}

	@And("I select from dropdown {string} the html attribute value {string}")
	public void i_select_from_dropdown_the_html_attribute_value() throws Throwable{

	}

	@And("I select radio option {string}")
	public void i_select_radio_option() throws Throwable{

	}

	@And("I enter into content editable {string} the value {string}")
	public void i_enter_into_content_editable_the_value() throws Throwable{

	}

	@And("I enter into autosuggest field {string} the value {string}")
	public void i_enter_into_autosuggest_field_the_value() throws Throwable{

	}

	@And("I select seat {string} the value {string}")
	public void i_select_seat_the_value() throws Throwable{

	}

	@And("I capture calendar previous {string} and next {string} buttons")
	public void i_capture_calendar_previous_and_next_buttons() throws Throwable{

	}

	@And("I select date {string} the value {string}")
	public void i_select_date_the_value() throws Throwable{

	}

	@And("I extract pageurl value as the variable {string}")
	public void i_extract_pageurl_value_as_the_variable() throws Throwable{

	}

	@And("I construct input source as variable {string} from")
	public void i_construct_input_source_as_variable_from() throws Throwable{

	}

	@And("I construct text as variable {string} appending")
	public void i_construct_text_as_variable_appending() throws Throwable{

	}

	@And("I capture value {string} as variable {string}")
	public void i_capture_value_as_variable() throws Throwable{

	}

	@And("I capture webelement {string} attribute {string} as variable {string}")
	public void i_capture_webelement_attribute_as_variable() throws Throwable{

	}

	@And("I check elseif {string} value as {string}")
	public void i_check_elseif_value_as() throws Throwable{

	}

	@And("I check elseif {string} match the regular expression {string}")
	public void i_check_elseif_match_the_regular_expression() throws Throwable{

	}

	@And("I check elseif {string} present")
	public void i_check_elseif_present() throws Throwable{

	}

	@And("I check elseif {string} not present")
	public void i_check_elseif_not_present() throws Throwable{

	}

	@And("I check elseif {string} is enabled")
	public void i_check_elseif_is_enabled() throws Throwable{

	}

	@And("I check elseif {string} is disabled")
	public void i_check_elseif_is_disabled() throws Throwable{

	}

	@And("I check and do else condition")
	public void i_check_and_do_else_condition() throws Throwable{

	}

	@And("I end loop")
	public void i_end_loop() throws Throwable{

	}

	@And("I check if {string} value as {string}")
	public void i_check_if_value_as() throws Throwable{

	}

	@And("I check if {string} present")
	public void i_check_if_present() throws Throwable{

	}

	@And("I check if {string} not present")
	public void i_check_if_not_present() throws Throwable{

	}

	@And("I check if {string} is disabled")
	public void i_check_if_is_disabled() throws Throwable{

	}

	@And("I check if {string} is enabled")
	public void i_check_if_is_enabled() throws Throwable{

	}

	@And("I end conditional check")
	public void i_end_conditional_check() throws Throwable{

	}

	@And("I loop if {string} has value {string}")
	public void i_loop_if_has_value() throws Throwable{

	}

	@And("I loop if {string} is greater than {string}")
	public void i_loop_if_is_greater_than() throws Throwable{

	}

	@And("I loop if {string} is less than {string}")
	public void i_loop_if_is_less_than() throws Throwable{

	}

	@And("I loop if {string} is equal to {string}")
	public void i_loop_if_is_equal_to() throws Throwable{

	}

	@And("I loop if {string} is not equal to {string}")
	public void i_loop_if_is_not_equal_to() throws Throwable{

	}

	@And("I assign {string} the value {string}")
	public void i_assign_the_value() throws Throwable{

	}

	@And("I increment {string} by {string}")
	public void i_increment_by() throws Throwable{

	}

	@And("I decrement {string} by {string}")
	public void i_decrement_by() throws Throwable{

	}

	@And("I loop on table {string} for rows {string}")
	public void i_loop_on_table_for_rows() throws Throwable{

	}

	@And("I loop if {string} present")
	public void i_loop_if_present() throws Throwable{

	}

	@And("I fetch data from database {string} using query {string} and push to data file")
	public void i_fetch_data_from_database_using_query_and_push_to_data_file() throws Throwable{

	}

	@And("I make a connection to database {string}")
	public void i_make_a_connection_to_database() throws Throwable{

	}

	@And("I run query {string} to fetch result as variable {string}")
	public void i_run_query_to_fetch_result_as_variable() throws Throwable{

	}

	@And("I connect to database {string} and run query {string}")
	public void i_connect_to_database_and_run_query() throws Throwable{

	}

	@And("I capture {string} first data column of table")
	public void i_capture_first_data_column_of_table() throws Throwable{

	}

	@And("I map comparison of {string} column with {string}")
	public void i_map_comparison_of_column_with() throws Throwable{

	}

	@And("I compare text to columns")
	public void i_compare_text_to_columns() throws Throwable{

	}

	@And("I compare table and db columns")
	public void i_compare_table_and_db_columns() throws Throwable{

	}

	@And("I read data file {string} to compare")
	public void i_read_data_file_to_compare() throws Throwable{

	}

	@And("I compare table and data file columns")
	public void i_compare_table_and_data_file_columns() throws Throwable{

	}

	@And("I get line containing phrase {string} from pdf file {string} into variable {string}")
	public void i_get_line_containing_phrase_from_pdf_file_into_variable() throws Throwable{

	}

	@And("I get line containing object {string} from web table into variable {string}")
	public void i_get_line_containing_object_from_web_table_into_variable() throws Throwable{

	}

	@And("I click on table {string} with condition {string}")
	public void i_click_on_table_with_condition() throws Throwable{

	}

	@And("I validate data on table {string} with condition {string} and data {string}")
	public void i_validate_data_on_table_with_condition_and_data() throws Throwable{

	}

	@And("I validate data on table {string} with columns {string} and datafile {string}")
	public void i_validate_data_on_table_with_columns_and_datafile() throws Throwable{

	}

	@And("I validate data on table {string} with datatable {string}")
	public void i_validate_data_on_table_with_datatable() throws Throwable{

	}

	@And("I validate data on table {string} with datafile {string}")
	public void i_validate_data_on_table_with_datafile() throws Throwable{

	}

	@And("I capture data on table {string} with condition {string} as variable {string}")
	public void i_capture_data_on_table_with_condition_as_variable() throws Throwable{

	}

	@And("I work with all same level tables")
	public void i_work_with_all_same_level_tables() throws Throwable{

	}

	@And("I capture data on table {string} as Excel")
	public void i_capture_data_on_table_as_excel() throws Throwable{

	}

	@And("I validate data on table {string} has value {string}")
	public void i_validate_data_on_table_has_value() throws Throwable{

	}

	@And("I validate column data on table {string} with condition {string} has value {string}")
	public void i_validate_column_data_on_table_with_condition_has_value() throws Throwable{

	}

	@And("I capture from table {string} the total number of rows as variable {string}")
	public void i_capture_from_table_the_total_number_of_rows_as_variable() throws Throwable{

	}

	@And("I capture from table {string} the total number of columns as variable {string}")
	public void i_capture_from_table_the_total_number_of_columns_as_variable() throws Throwable{

	}

	@And("I validate data on datatable {string} with columns {string} and table {string} delimit {string} value")
	public void i_validate_data_on_datatable_with_columns_and_table_delimit_value() throws Throwable{

	}

	@And("I validate data on datatable {string} with columns {string} and table {string}")
	public void i_validate_data_on_datatable_with_columns_and_table() throws Throwable{

	}

	@And("I check if {string} match the regular expression {string}")
	public void i_check_if_match_the_regular_expression() throws Throwable{

	}

	@And("I end SOAP conditional check")
	public void i_end_soap_conditional_check() throws Throwable{

	}

	@And("I download the request")
	public void i_download_the_request() throws Throwable{

	}

	@And("I fetch api data from database {string} using query {string} and push to data file")
	public void i_fetch_api_data_from_database_using_query_and_push_to_data_file() throws Throwable{

	}

	@And("I reset authentication as token based with token {string}")
	public void i_reset_authentication_as_token_based_with_token() throws Throwable{

	}

	@And("I reset authentication as no authentication")
	public void i_reset_authentication_as_no_authentication() throws Throwable{

	}

	@And("I reset authentication as basic authentication")
	public void i_reset_authentication_as_basic_authentication() throws Throwable{

	}

	@And("I set {string} as base URL")
	public void i_set_as_base_url() throws Throwable{

	}

	@And("I declare rest service with end point {string} using method {string}")
	public void i_declare_rest_service_with_end_point_using_method() throws Throwable{

	}

	@And("I set request parameter property {string} with value {string}")
	public void i_set_request_parameter_property_with_value() throws Throwable{

	}

	@And("I set request header property {string} with value {string}")
	public void i_set_request_header_property_with_value() throws Throwable{

	}

	@And("I set basic authentication username {string} and password {string}")
	public void i_set_basic_authentication_username_and_password() throws Throwable{

	}

	@And("I set token based authentication")
	public void i_set_token_based_authentication() throws Throwable{

	}

	@And("I set request property {string} with value {string}")
	public void i_set_request_property_with_value() throws Throwable{

	}

	@And("I set request property {string} with boolean value {string}")
	public void i_set_request_property_with_boolean_value() throws Throwable{

	}

	@And("I set request property {string} with double value {string}")
	public void i_set_request_property_with_double_value() throws Throwable{

	}

	@And("I set request property {string} with int value {string}")
	public void i_set_request_property_with_int_value() throws Throwable{

	}

	@And("I set request property {string} with long value {string}")
	public void i_set_request_property_with_long_value() throws Throwable{

	}

	@And("I set request from json object")
	public void i_set_request_from_json_object() throws Throwable{

	}

	@And("I set request from json object having name {string}")
	public void i_set_request_from_json_object_having_name() throws Throwable{

	}

	@And("I set request header cookie property {string} with value {string}")
	public void i_set_request_header_cookie_property_with_value() throws Throwable{

	}

	@And("I set request header cookie property {string} with value {string} and additional value {string}")
	public void i_set_request_header_cookie_property_with_value_and_additional_value() throws Throwable{

	}

	@And("I set request property {string} as text type form data with value {string}")
	public void i_set_request_property_as_text_type_form_data_with_value() throws Throwable{

	}

	@And("I connect to database {string} and run DML query {string}")
	public void i_connect_to_database_and_run_dml_query() throws Throwable{

	}

	@And("I make a connection to database {string} for ap")
	public void i_make_a_connection_to_database_for_ap() throws Throwable{

	}

	@And("I run query {string} to fetch result as api variable {string}")
	public void i_run_query_to_fetch_result_as_api_variable() throws Throwable{

	}

	@And("I append end point with key as {string} and value {string}")
	public void i_append_end_point_with_key_as_and_value() throws Throwable{

	}

	@And("I set request property {string} as file with path {string}")
	public void i_set_request_property_as_file_with_path() throws Throwable{

	}

	@And("I set request json object from data file as {string}")
	public void i_set_request_json_object_from_data_file_as() throws Throwable{

	}

	@And("I set cookies into request header from variable {string}")
	public void i_set_cookies_into_request_header_from_variable() throws Throwable{

	}

	@And("I reset request schema array property min item {string} with value {string} and max item {string} with value {string}")
	public void i_reset_request_schema_array_property_min_item_with_value_and_max_item_with_value() throws Throwable{

	}

	@And("I append to request header property {string} with value {string}")
	public void i_append_to_request_header_property_with_value() throws Throwable{

	}

	@And("I invoke client {string} with input arguments")
	public void i_invoke_client_with_input_arguments() throws Throwable{

	}

	@And("I capture return value as {string} from client {string} invoked with input arguments")
	public void i_capture_return_value_as_from_client_invoked_with_input_arguments() throws Throwable{

	}

	@And("I set login class as {string}")
	public void i_set_login_class_as() throws Throwable{

	}

	@And("I set end point as {string}")
	public void i_set_end_point_as() throws Throwable{

	}

	//OTFA - End ******************************************//
	@And("I get IGNITE Steps")
	public void i_get_ignite_steps(){
		GUI.getIGNITE();
	}

	@Given("I launch the {string} Application")
	public void i_launch_the_Application(String string) throws Throwable {
		GUI.launchApplication(string);
		element = new JSONTool_ObjectElements();
		element.init();
		switch(curApplication) {
		case "UCI" : GUI = new UCI();
		break;
		case "PORTAL" : GUI = new PORTAL();
		break;
		}
	}

	@And("I login to the Application as {string}")
	public void i_login_to_the_Application_with_and(String username) throws Throwable {
		GUI.login(username);
	}

	@Then("I Sign-Out of Application")
	public void i_sign_out_of_application() throws Throwable {
		GUI.signOut();
	}

	@And("I Submit the SR")
	public void i_Submit_the_SR() throws Throwable {
		GUI.submitSR();
	}

	@And("I navigate to Service Request")
	public void i_navigate_to_Service_Request() throws Throwable {
		GUI.navigateToSRArea();
	}

	@And("I start a new Service Request")
	public void i_start_a_new_Service_Request() throws Throwable {
		GUI.startNewSR();
	}

	@And("I select form type of {string}")
	public void I_select_form_type_of(String string) throws Throwable {
		GUI.selectForm(string);
	}

	@Then("I validate SR was Submitted Successfully")
	public void i_validate_SR_was_Submitted_Successfully() throws Throwable {
		//How to set if fail
		GUI.validateSRCreation();
	}

	@And("I select from Lookup {string} the Object value {string}")
	public void i_select_from_lookup_the_object_value(String string, String string2) throws Throwable {
		GUI.lookupSelect(string, string2);
	}

	@And("I select from Search {string} with Object value {string}")
	public void i_select_from_search_the_object_value(String string, String string2) {
		GUI.searchSelect(string, string2);
	}

	@And("I set DateTime to Object {string} the Object value {string}")
	public void i_set_DateTime_to_Object_the_object_value(String string, String string2) throws Throwable {
		//Not done
		GUI.validateSRCreation();
	}

	@And("I select from OptionSet {string} the Object value {string}")
	public void i_select_from_OptionSet_the_object_value(String string, String string2) throws Throwable {
		GUI.optionSetSelect(string, string2);
	}

	@And("I toggle radio {string} to {string}")
	public void I_toggle_radio_to(String string, String string2) throws Throwable {
		GUI.toggleRadioButton(string, string2);
	}

	@And("I set text to Object {string} with value {string}")
	public void i_set_text_to_object_with_value(String string, String string2) throws Throwable {
		GUI.setText(string, string2);
	}

	@And("I click Object {string} button")
	public void i_click_object_button(String string) throws Throwable {
		GUI.clickButton(string);
	}

	@Then("I validate Object exists {string}")
	public void i_validate_object_exists(String string) throws Throwable {
		GUI.objectExists(string);
	}

	@Then("I validate Object does not exist {string}")
	public void i_validate_object_does_not_exist(String string) throws Throwable {
		GUI.doesNotExist(string);
	}

	@Then("I validate Object {string} contains text of {string}")
	public void i_validate_object_contains_text_of(String string, String string2) throws Throwable {
		GUI.containsText(string, string2);
	}

	@Then("I validate Object {string} label text {string}")
	public void i_validate_object_label_text_of(String string, String string2) throws Throwable {
		GUI.validateLabel(string, string2);
	}

	@Then("I validate Object {string} has Error")
	public void i_validate_Object_has_Error(String string) throws Throwable {
		GUI.hasError(string);
	}

	@Then("I validate Object {string} has this ErrorMsg {string}")
	public void i_validate_Object_has_this_ErrorMsg(String string,String string2) throws Throwable {
		GUI.validateErrorMsg(string, string2);
	}

	@And("I get Text from Lookup {string}")
	//Not Done
	public void test_step_template(String string) throws Throwable {
		GUI.validateSRCreation();
	}

	@Then("I validate the SR is {string}")
	public void I_validate_the_SR_is(String string) throws Throwable {
		GUI.validateSRCreation();
	}

	@Then("I validate field {string} has label {string}")
	public void I_validate_field_has_label(String string, String string2) throws Throwable{
		GUI.validateLabel(string, string2);
	}

	@Before
	public void InitializeTest(Scenario scenario) {
		try {
			firstError =0;
			currentStepDefIndex=0;
			lastPassed=true;
			System.out.println("Start Scenario");
			utility.wait(3000);
			setScenario(scenario);
			curFeature =scenario1.getId().substring(scenario1.getId().lastIndexOf("/") + 1,scenario1.getId().lastIndexOf("."));
			testData.init();
			curScenario = scenario1.getName();
			extentReportUtil.htmlReporter.config().setReportName(curFeature);
			extentReportUtil.extent.attachReporter(extentReportUtil.htmlReporter);
			utility.writeToLog("curFeature:" + curFeature);
			utility.writeToLog("curScenario:" + curScenario);
			GlobalVars.features = extentReportUtil.extent.createTest(Feature.class, curScenario);
			scenarioDef = features.createNode(scenario1.getName());
			testData.setTestSuite(curFeature);
			testData.setTestCase(curScenario);
			if(preFeature == null) {
				dataCount = 1;
			}else if(preFeature.equals(curFeature) && preScenario.equals(curScenario)) {
				dataCount++;
			}else {
				dataCount = 1;
			}
			testData.setTestSet(Integer.toString(dataCount));
		}catch(Exception e) {
			utility.writeToLog(e.getMessage());
		}
	}

	@After 
	public void finish() throws IOException, InterruptedException {	
		if(!driverUtils.driverClosed) {
			preFeature = curFeature;
			preScenario = curScenario;
			frames = null;
			if(driverUtils.driver != null) {
				driverUtils.driver.close();
				driverUtils.driver.quit();
				driverUtils.driverClosed = true;
			}
		}
	}

	@BeforeStep
	public void beforeStep() {
		try {
			utility.getStepText();
			utility.buildStepDescription();
			//utility.loadXpaths(utility.getObjectName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterStep
	public void afterStep() throws Throwable {
		currentStepDefIndex++;
		utility.setStatus();
		if(!lastPassed) {
			Assertions.isTrue(null, false);
			finish();
		}
	}

	public void setScenario(Scenario scenario) {
		scenario1 = scenario;
	}
}