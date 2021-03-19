(ns clojure-first-steps.exception)

(defn exceptionHandling
  [x]
  (try
    (inc x)
    (catch Exception e
      ;.getMessage is from java
      (println "Caught exception:" (.getMessage e))
      )
    (catch ClassCastException e
      (println "Caught generic exception")
      )
    (finally
      (println "Cleanup and move on")
      )
    )
  )
(exceptionHandling "oi")