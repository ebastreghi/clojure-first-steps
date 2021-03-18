(ns clojure-first-steps.loops)

(defn loopFnc
  []
  (println "loop")
  (loop [x 0]
        (when (< x 10)
          (println x)
          (recur (inc x))
          )
        )
  )
(loopFnc)

(defn doTimes
  []
  (println "do times")
  (dotimes [x 11]
    (println x)
    )
  )
(doTimes)

(defn whileDo
  [count]
  (println "whileDo")
  (def x (atom 0))
  (while (< @x count)
    (do
      (println @x)
      (swap! x inc)
      )
    )
  )
(whileDo 8)

(defn doSeq
  [seqArray]
  (println "doSeq: before")
  (doseq [x seqArray]
    (println (inc x))
    )
  )
(doSeq [6 3 5 8 7 1])