(ns clojure-first-steps.destructuring)

(defn destruct
  []
  (def myVect [1 2 3 4 5])

  ;a b c are variables
  ;1 2 3
  (let [[a b c] myVect] (println a b c))

  ;1 2 (3 4 5)
  (let [[a b & rest] myVect] (println a b rest))

  (def myMap {'name "John" 'lastname "Smith"})
  ;John Smith
  (let [{a 'name b 'lastname} myMap] (println a b))
  ;John Smith nil
  (let [{a 'name b 'lastname c 'noname} myMap] (println a b c))
  )
(destruct)