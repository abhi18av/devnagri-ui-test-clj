(ns user
  (:require [sparkledriver.browser :as sprkl-browser]
            [sparkledriver.element :as sprkl-element]
            [sparkledriver.cookies :as sprkl-cookies]
            [sparkledriver.retry :as sprkl-retry]))



(sprkl-browser/with-browser [browser (sprkl-browser/make-browser :headless false)]
  (-> (sprkl-browser/fetch! browser "http://clojure.org")
      (sprkl-element/find-by-xpath* "//div[@class='clj-intro-message']/p")
      (nth 2)
      sprkl-element/text))



