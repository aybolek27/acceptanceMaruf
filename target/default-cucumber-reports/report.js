$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/com/prestashop/features/search/sort_by.feature");
formatter.feature({
  "name": "Sorting options on the search result page",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test sort by dropdown",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@temp"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user is on the home page",
  "keyword": "Given "
});
formatter.match({
  "location": "HomePageStepDef.the_user_is_on_the_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user clicks on link Dresses",
  "keyword": "When "
});
formatter.match({
  "location": "SearchStepsDef.the_user_clicks_on_link_Dresses()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should be able to sort results",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchStepsDef.the_user_should_be_able_to_sort_results()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:86)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat org.junit.Assert.assertTrue(Assert.java:52)\r\n\tat com.prestashop.step_definitions.SearchStepsDef.the_user_should_be_able_to_sort_results(SearchStepsDef.java:96)\r\n\tat ✽.the user should be able to sort results(src/test/resources/com/prestashop/features/search/sort_by.feature:38)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});