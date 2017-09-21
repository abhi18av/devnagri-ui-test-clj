
import $ivy.`com.machinepublishers:jbrowserdriver:0.17.9`
import com.machinepublishers
import org.openqa.selenium.WebDriver;
import com.machinepublishers.jbrowserdriver.Timezone;
import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.Settings


// JBrowserDriver driver = new JBrowserDriver(Settings.builder().timezone(Timezone.AMERICA_NEWYORK).build());



val driver = new JBrowserDriver(Settings.builder().headless(false).timezone(Timezone.AMERICA_NEWYORK).build());


// This will block for the page load and any
// associated AJAX requests
driver.get("http://google.com");

// You can get status code unlike other Selenium drivers.
// It blocks for AJAX requests and page loads after clicks
// and keyboard events.
println(driver.getStatusCode());

// Returns the page source in its current state, including
// any DOM updates that occurred after page load
//println(driver.getPageSource());

// Close the browser. Allows this thread to terminate.
driver.quit();
