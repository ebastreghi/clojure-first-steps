(ns clojure-first-steps.sequences)

(defn seqFnc
  []

  ;(red green blue)
  (def colors (seq ["red" "green" "blue"]))
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

  (println (sort (seq [1 5 8 9 2 3])))
  )
(seqFnc)