(ns clojure-first-steps.functions
  (:gen-class))

 (defn -main
  "First function"
  []
   (println "My name is Edevar")
   (println "loving Clojure so far")
   (+ 2 5))

;Hello anonymous function nil
(println "Hello anonymous function")
;#object[clojure_first_steps.core$eval1588$fn__1589 0x3f2f6bc "clojure_first_steps.core$eval1588$fn__1589@3f2f6bc"]
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

;clojure.lang.Keyword
(type :a)

;clojure.lang.Symbol
(type 'a)

;SET
#{1 1.5 42 "hello"}
(hash-set 1 1.5 42 "hello")

;MAP
{:name "Edevar", :age 34}
(hash-map :name "Edevar" :age 34)

;ARRAY
[1 2 3 4]
(vector 1 2 3 4)

;LIST(make up the code)
(1 2 3 4 "One")
(list 1 2 3 4 "One")

;the list bellow is interpreted as a function definition
(defn func [] (println "hi"))
;this list is interpreted as a call of function
(func)

;when I use let to declare a variable it's gonna be
;valid only within the parentheses
;ie if you try to access "x" out of the parentheses
; it's not gonna be "Steve"
(let [x "Steve"]
  (println x)
  )

;we can use the predicate "empty?" in the if statement
(if (empty? x)
  "x id empty"
  "x is not empty"
  )

(if-not (empty? x)
  (do
    (println "Ok")
    :ok
    )
  )

; set a function in a variable
(def helloFnc (fn [] "Hello"))

;require a doc that is gonna appear in console
(require '[clojure.repl :refer [doc]])
(doc helloFnc)

;different implementation according with the parameters
(defn helloOverhead
  ([] "Hello")
  ([name] ("Hello " name))
  )

;str return a concatenation of strings
(defn test
  [config]
  (str "Hello, " (:name config))
  )

;extract the map value in parameter
(defn testExtrat
  [{name :name}]
  (str "Hello, " name)
  )