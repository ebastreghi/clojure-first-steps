(ns clojure-first-steps.sequences)

(defn seqFnc
  []

  ;(red green blue)
  ;Returns a seq on the collection. If the collection is empty, returns nil.
  ;seq also works on Strings, native Java arrays (of reference types) and any objects that implement Iterable.
  (def colors (seq ["red" "green" "blue"]))
  (def colorList ("red" "green" "blue"))
  (println colors)

  ;; 'seq' can be used to turn a map into a list of vectors.
  ;; Notice how the list is built adding elements to the beginning
  (seq {:key1 "value1" :key2 "value2"})
  ;;=> ([:key2 "value 2"] [:key1 "value 1"])

  ;; (seq x) is the recommended idiom for testing if a collection is not empty
  (every? seq ["1" [1] '(1) {:1 1} #{1}])
  ;;=> true

  ;(yellow red green blue)
  ;[x seq]  Returns a new seq where x is the first element and seq is the rest.
  (println (cons "yellow" colors))

  ;(yellow red green blue)
  ;[coll x & xs]  conj[oin]. Returns a new collection with the xs 'added'
  (println (conj colors "yellow"))

  ;; notice that conjoining to a vector is done at the end
  (conj [1 2 3] 4)
  ;;=> [1 2 3 4]

  ;; notice conjoining to a list is done at the beginning
  (conj '(1 2 3) 4)
  ;;=> (4 1 2 3)

  (conj [[1 2] [3 4]] [5 6])
  ;;=> [[1 2] [3 4] [5 6]]

  ;((red green blue) b l a c k)
  (println (cons colors "black"))

  ;[red green blue black]
  ;add element in the end of the vector
  (println (conj ["red" "green" "blue"] "black"))

  ;(red green blue black white)
  ;Returns a lazy seq representing the concatenation of the elements in the supplied colls.
  (println (concat colors (seq ["black" "white"])))

  ;return a clojure.lang.LazySeq
  (concat colors colorList)

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

  user=> (sort > (vals {:foo 5, :bar 2, :baz 10}))
  (10 5 2)

  ;; do not do this, use sort-by instead
  user=> (sort #(compare (last %1) (last %2)) {:b 1 :c 3 :a  2})
  ;([:b 1] [:a 2] [:c 3])

  ;; like this:
  user=> (sort-by last {:b 1 :c 3 :a 2})
  ;([:b 1] [:a 2] [:c 3])

  ;assoc[iate]. When applied to a map, returns a new map of the same (hashed/sorted) type, that contains the mapping of key(s) to val(s).
  ; When applied to a vector, returns a new vector that contains val at index.
  (assoc {:a 1} :b 2)

  (assoc {} :key1 "value" :key2 "another value")
  ;;=> {:key2 "another value", :key1 "value"}

  ;; Here we see an overwrite by a second entry with the same key
  (assoc {:key1 "old value1" :key2 "value2"}
    :key1 "value1" :key3 "value3")
  ;;=> {:key3 "value3", :key2 "value2", :key1 "value1"}

  ;; We see a nil being treated as an empty map
  (assoc nil :key1 4)
  ;;=> {:key1 4}

  ;; 'assoc' can be used on a vector (but not a list), in this way:
  ;; (assoc vec index replacement)
  (assoc [1 2 3] 0 10)     ;;=> [10 2 3] in the index 0 the number 1 was replaced by the number 10
  (assoc [1 2 3] 2 '(4 6)) ;;=> [1 2 (4 6)]
  ;; Next, 0 < index <= n, so the following will work
  (assoc [1 2 3] 3 10)     ;;=> [1 2 3 10]
  ;; However, when index > n, an error is thrown
  (assoc [1 2 3] 4 10)
  ;; java.lang.IndexOutOfBoundsException (NO_SOURCE_FILE:0)

  ;; convert a vector into a set with assoc
  (def book-city  {:awards ["Hugo" "World Fantasy Award" "Arthur C. Clarke Award"
                            "British Science Fiction Award"]
                   :title "The City and the City"
                   :authors [{:birth-year 1972, :name "China Miéville"}]})

  (assoc book-city :authors (set (:authors book-city)))
  ;or
  (assoc-in book-city [:authors] (set (:authors book-city)))

  ;;assoc applied to a vector
  (def my-vec [1 2 5 6 8 9])
  (assoc my-vec 0 77)
  ;;[77 2 5 6 8 9]

  ;{:settings {:a "a", :b 2}}
  (assoc-in {:settings {:a 1 :b 2}} [:settings :a] "a")

([] inc)

  (def m {:a 1 :b 2}))
(seqFnc)