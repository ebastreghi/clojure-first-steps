(ns clojure-first-steps.atoms)
;atom is a type of variable that can be changed
;swap! reset! compare-and-set! are ways to change an atom in a thread safe way
(defn atoms
  []
  (def amount (atom 100))
  (println @amount)

  (swap! amount inc)
  (println @amount)

  (reset! amount 110)
  (println @amount)

  (compare-and-set! amount 110 120)
  (println @amount)
  (compare-and-set! amount 110 150)
  (println @amount)
  )
(atoms)