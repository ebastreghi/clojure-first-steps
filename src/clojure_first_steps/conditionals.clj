(ns clojure-first-steps.conditionals)

(defn condIf
  []
  (println "condIf: before if")
  (if (= 5 6)
    (println "equal")
    (println "not equal")
    )
  )
(condIf)

(defn condIdDo
  []
  (println "condIdDo: before if")
  (if (= 5 5)
    (do (println "equal 1")
        (println "equal 2"))
    (do (println "not equal 1")
        (println "not equal 2")))
  )
(condIdDo)

(defn codIfNested
  []
  (println "codIfNested: before if")
  (if (and (= 5 5) (or (= 2 2) (not true)))
    (println "true")
    (println "false")
    )
  )
(codIfNested)

(defn condCase
  [pet]
  (println "condCase: before")
  (case pet
    "cat" (println "I have a cat")
    "dog" (println "I have a dog")
    "fish" (println "I have a goldfish")
    )
  )
(condCase "dog")

(defn condCond
  [amount]
  (println "condCond: before")
  (cond
    (<= amount 2) (println "few")
    (<= amount 10) (println "several")
    (<= amount 100) (println "many")
    :else (println "loads")
    )
  )
(condCond 5)