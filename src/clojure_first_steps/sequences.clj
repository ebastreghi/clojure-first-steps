(ns clojure-first-steps.sequences)

(defn seqFnc
  []
  (def colors (seq ["red" "green" "blue"]))
  (println colors)

  ;append elements in the beginning
  (println (cons "yellow" colors))

  ;((red green blue) b l a c k)
  (println (cons colors "black"))

  ;add element in the beginning
  (println (conj colors "black"))

  ;add element in the end of the vector
  (println (conj ["red" "green" "blue"] "black"))

  ;concat a sequence in the end of colors
  (println (concat colors (seq ["black" "white"])))
  
  (println (distinct (seq [1 2 3 4 3 1])))
  
  (println (reverse colors))
  
  (println (first colors))

  ;the rest the elements except the first
  (println rest colors)

  (println (last colors))

  (println (sort (seq [1 5 8 9 2 3])))
  )
(seqFnc)