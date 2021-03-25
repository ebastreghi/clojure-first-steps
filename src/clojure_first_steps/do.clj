(ns clojure-first-steps.do)

;Evaluates the expressions in order and returns the value of the last. If no
;expressions are supplied, returns nil. See http://clojure.org/special_forms
;for more information.

;; do is used to evaluate multiple expressions in order, usually for the
;; purpose of evaluating exprs that have side-effects (such as printing
;; or I/O).  do returns the value of its last expression.
;;
;; do w/o args returns nil.

=> (do
     (println "LOG: Computing...")
     (+ 1 1))
LOG: Computing...
2

=> (do)
nil




;; `fn` (`defn` by extension) and `let` have an implicit `do`
=> ((fn []
      (println "Something") ; printed in stdout
      (str "Return this")))
"Return this"

=> (defn do-example []
     (println "Something") ; printed in stdout
     (str "Return this")))
=> (do-example)
"Return this"

=> (let [name "John"]
     (println "Something") ; printed in stdout
     (str "Hello " name))
"Hello John"


user=> (if (> 2 1)
         (do
           (print "2 greater than 1") ; with 'do' you can extend if block
           true))

;;=>"2 greater than 1"
;;=>true


;; Print the result of time without the output of (range 1000)

=> (do (time (range 1000)) nil)