(ns clojure-first-steps.macros)

;macro generate code from code
;=> (if (= 2 2) (do (println "hello")))
(macroexpand-1 '(when (= 2 2) (println "hello")))