(ns clojure-first-steps.weirdCharacters)

(defn group-even
  [acc next-val]
  (let [key (if (even? next-val)
              :even
              :odd)]

    ;"update-in" -> collection, attribute function
    (update-in acc [key] #(conj % next-val))))


;{:even (6 4 2 0), :odd (5 3 1)}
(println (reduce group-even {} [0 1 2 3 4 5 6]))
;{:even [0 2 4 6], :odd [1 3 5]}
(println (group-by #(if (even? %) :even :odd) [0 1 2 3 4 5 6]))