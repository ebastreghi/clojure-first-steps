(ns clojure-first-steps.promises)

;[^Class c x]  Evaluates x and tests if it is an instance of the class c.
; Returns true or false
(instance? Runnable (fn []))

(.start (Thread. (fn [] (println "Hello thread"))))

;Returns a promise object that can be read with deref/@, and set, once only,
;with deliver.
(promise)

(deliver (promise) "Hello promise")