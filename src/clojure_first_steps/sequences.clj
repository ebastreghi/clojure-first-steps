(ns clojure-first-steps.sequences)

(defn seqFnc
  []

  ;(red green blue)
  (def colors (seq ["red" "green" "blue"]))
  (def colorList ("red" "green" "blue"))
  (println colors)

  ;(yellow red green blue)
  ;append elements in the beginning
  (println (cons "yellow" colors))

  ;(yellow red green blue)
  ;add element in the beginning
  (println (conj colors "yellow"))

  ;((red green blue) b l a c k)
  (println (cons colors "black"))

  ;[red green blue black]
  ;add element in the end of the vector
  (println (conj ["red" "green" "blue"] "black"))

  ;(red green blue black white)
  ;concat a sequence in the end of colors
  (println (concat colors (seq ["black" "white"])))

  ;(1 2 3 4)
  (println (distinct (seq [1 2 3 4 3 1])))
  
  (println (reverse colors))
  
  (println (first colors))

  ;the rest the elements except the first
  (println (rest colors))

  (println (last colors))

  ;choose the position
  (println (nth colors 1))

  (println (sort (seq [1 5 8 9 2 3])))

  ;return a clojure.lang.LazySeq
  (concat colors colorList)

  (assoc {:a 1} :b 2)
  ;{:settings {:a "a", :b 2}}
  (assoc-in {:settings {:a 1 :b 2}} [:settings :a] "a")
  ;{:settings {:a 2, :b 2}}
  (update-in {:settings {:a 1 :b 2}} [:settings :a] inc)

  (def m {:a 1 :b 2})
  ;1
  (get m :a)
  ;1
  (:a m)

  (def s #{1 2 3})
  ;#{1 2 3 4}
  (conj s 4)
  ;#{1 2}
  (disj s 3)
  (contains? s 3)

  )
(seqFnc)