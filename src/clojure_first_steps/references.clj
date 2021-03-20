(ns clojure-first-steps.references)

(defn refs
  []

  ;the act on "ref" data type we can only use transactions
  (def amount (ref 100))
  (println @amount)

  ;create a transaction
  ;we can have multiple threads doing transactions
  ;on the same data type at the same time
  (dosync
    (ref-set amount 110)
    )
  (println @amount)

  (dosync
    ;alter allow us to use a function in the "ref"
    (alter amount inc)
    )
  (println @amount)

  )
(refs)