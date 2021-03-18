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

(defn DataTypes
  []
  (def a 1)
  (def b 1.25)
  (def c 1.25e-12)
  (def d 0xfbfc)
  (def e nil)
  (def f true)
  (def g "Hello")
  ;keyword
  (def h 'thanks)
  ;case sensitive
  (def status true)
  (def STATUS false)


  (println a)
  (println b)
  (println c)
  (println d)
  )
;call the function
(DataTypes)

;SET
#{1 1.5 42 "hello"}

;MAP
#{:name "Edevar", :age 34}

;ARRAY
[1 2 3 4]

;LIST(make up the code)
(1 2 3 4 "One")
;the list bellow is interpreted as a function definition
(defn func [] (println "hi"))
;this list is interpertred as a call of function
(func)

