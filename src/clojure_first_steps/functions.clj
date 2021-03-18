(ns clojure-first-steps.functions
  (:gen-class))

 (defn -main
  "First function"
  []
   (println "My name is Edevar")
   (println "loving Clojure so far")
   (+ 2 5))

#(println "Hello anonymous function")
#(println "Hello " %1 %2)

(def increment (fn [x] (+ x 1)) )

;(defn increment_set
;  []
;  (map increment [1 2 3]))

(defn increment_set
  [x]
  (map increment x)
  )