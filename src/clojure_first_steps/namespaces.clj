(ns clojure-first-steps.namespaces
  (:require [clojure-first-steps.petAge])
  (:require [clojure.string :refer [capitalize]])
  (:require [clojure-first-steps.destructuring :refer :all])
  )

(defn -main
  []
  (println clojure-first-steps.petAge/age "Fido" 'dog 4)
  (println  (capitalize "hello"))
  )
(-main)