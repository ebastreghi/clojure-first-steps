(ns clojure-first-steps.recursive)

(defn my-sum
  [total vals]
  (if (empty? vals)
    total
    (my-sum (+ (first vals) total) (rest vals))
    )
  )
 (println (my-sum 0 [0 1 2 3 4 5]))

(defn my-sum2
  ([vals] (my-sum2 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (my-sum2 (+ (first vals) total) (rest vals))
     )
   )
  )
(println (my-sum2 [0 1 2 3]))

;tail recursion, use recur instead the name of the function
(defn tailRecur
  ([vals] (tailRecur 0 vals))
  ([total vals]
   (if (empty? vals)
     total
     (recur (+ (first vals) total) (rest vals))
     )
   )
  )
(println (tailRecur [0 1 2 3 4 5 6]))

;in "reduce" the first parameter is a function
(println (reduce (fn [total vals] (+ total vals)) 0 [0 1 2 3 4 5] ))

(defn summer
  [total vals]
  (+ total vals)
  )
(reduce summer 0 [0 1 2])

(reduce + 0 [0 1 2])

(defn filter-even
  [acc next-val]
  (if (even? next-val)
    (conj acc next-val)
    acc
    )
  )
;[0 2 4 6]
(println (reduce filter-even [] [0 1 2 3 4 5 6]))
;(0 2 4 6)
(println (filter even? [0 1 2 3 4 5 6]))


(defn group-even
  [acc next-val]
  (let [key (if (even? next-val)
              :even
              :odd
              )]
    ;"update-in" -> collection, attribute function
    (update-in acc [key] #(conj % next-val))
    )
  )
;{:even (6 4 2 0), :odd (5 3 1)}
(println (reduce group-even {} [0 1 2 3 4 5 6]))
;{:even [0 2 4 6], :odd [1 3 5]}
(println (group-by #(if (even? %) :even :odd) [0 1 2 3 4 5 6]))

(defn map-inc
  [acc next-val]
  (conj acc (inc next-val))
  )
;[1 2 3 4]
(println (reduce map-inc [] [0 1 2 3]))
;(1 2 3 4)
(println (map inc [0 1 2 3]))