(ns clojure-first-steps.petAge)

(defn petToHumanAge
  "This function returns the age of the pet is human years"
  [mapKey]
  (def petMap {'dog 7, 'cat 5, 'goldfish 10})
  ;(def petMap {:dog 7, :cat 5, :goldfish 10})
  (get petMap mapKey)
  )

;return 7
;(petToHumanAge 'dog)

(defn age
  "This function returns the age of a pet"
  [petName petType petAge]
  ;immutable variable ratio is initialized
  (def ratio (petToHumanAge petType))
  (println petName "is" (* ratio petAge) "years old in human years")
  )

(age "Fido" 'dog 4)
(age "Fifi" 'cat 2)
(age "Bubbles" 'goldfish 10)