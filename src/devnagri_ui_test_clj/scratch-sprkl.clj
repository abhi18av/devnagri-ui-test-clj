(ns user
  (:require [sparkledriver.browser :as sprkl-browser]
            [sparkledriver.element :as sprkl-element]
            [sparkledriver.cookies :as sprkl-cookies]
            [sparkledriver.retry :as sprkl-retry]))



(def browser-options
  {;; how long to wait for resources loaded by ajax, in milliseconds (default is quite long)
   :ajax-load-timeout [30000 #(.ajaxResourceTimeout %1 %2)]
   ;; how long to wait for JS to run after page load, in milliseconds
   :ajax-wait         [200 #(.ajaxWait %1 %2)]
   ;; whether requests to ad/spam servers should be blocked
   :block-ads         [false #(.blockAds %1 %2)]
   ;; use a local browser cache
   :cache             [true #(.cache %1 %2)]
   ;; if false, open a window so you can watch it work
   :headless          [true #(.headless %1 %2)]
   ;; increased logging
   :log-trace         [false #(.logTrace %1 %2)]
   :log-wire          [false #(.logWire %1 %2)]
   ;; we pretend to be Chrome
   :request-headers   [com.machinepublishers.jbrowserdriver.RequestHeaders/CHROME #(.requestHeaders %1 %2)]
   ;; store copies of media and attachments in a temporary folder
   :save-attachments  [true #(.saveAttachments %1 %2)]
   :save-media?       [true #(.saveMedia %1 %2)]
   ;; set browser screen dimentions - 1366x768 by default (we're a laptop)
   :screen-size       [[1366 768] (fn [builder [w h]]
                                    (.screen builder (org.openqa.selenium.Dimension. w h)))]
   ;; be accepting of weird SSL certs
   :ssl-policy        ["compatible" #(.ssl %1 %2)]
   ;; We're in New York, no matter where we are
   :timezone          [com.machinepublishers.jbrowserdriver.Timezone/AMERICA_NEWYORK #(.timezone %1 %2)]
   ;; no, really, we're Chrome
   :user-agent        [com.machinepublishers.jbrowserdriver.UserAgent/CHROME #(.userAgent %1 %2)]
   ;; SSL certificate verification, off by default because the internet is broken
   :verify-hostname?  [false #(.hostnameVerification %1 %2)]})




(sprkl-browser/with-browser [browser (sprkl-browser/make-browser )]
  (-> (sprkl-browser/fetch! browser "http://clojure.org")
      (sprkl-element/find-by-xpath* "//div[@class='clj-intro-message']/p")
      (nth 2)
;      (sprkl-browser/execute-script browser "console.log(\"hi\")")))
      sprkl-element/text))





(sprkl-browser/make-browser :headless false :logJavascript [] )

;;;;;;;;;;; RAW JAVA INTEROP


(require 'com.machinepublishers.jbrowserdriver.Settings)
