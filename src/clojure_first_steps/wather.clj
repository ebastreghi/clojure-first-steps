(ns clojure-first-steps.wather)

(defn watch
  []
  (def x (atom 5))
  (add-watch x :xWatcher
             (fn [key atom old-estate new-state]
               (println key)
               (println atom)
               (println old-estate)
               (println new-state)
               )
    )
  (reset! x 10)
  (remove-watch x :xWatcher)
  (reset! x 15)
  )
(watch)