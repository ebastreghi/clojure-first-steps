(ns clojure-first-steps.bankMerchant)

(def buyerBalance (ref 100))
(def merchantBalance (ref 0))
(def itemsMap {'pen 1, 'notebook 5, 'backpack 10})
(def purchasedItems (ref []))

(defn printInfo
  []
  (println "----------")
  (println "buyerBalance: " @buyerBalance)
  (println "merchantBalance: " @merchantBalance)
  (println "purchasedItems: " @purchasedItems)
  )

(defn buyItem
  [itemMapToBePurchased]

  (def itemPrice (get itemsMap itemMapToBePurchased))
  (if (<= itemPrice @buyerBalance)
    ;this code snippet its gonna be executed in a atomic way
    (dosync
      (ref-set buyerBalance (- @buyerBalance itemPrice))
      (ref-set merchantBalance (+ @merchantBalance itemPrice))
      (ref-set purchasedItems (cons itemMapToBePurchased @purchasedItems))
      )
    ;else
    (println "Insufficient balance")
    )
  (printInfo)
  )

(buyItem 'pen)
(buyItem 'pen)
(buyItem 'notebook)
(buyItem 'backpack)
(buyItem 'backpack)
(buyItem 'pen)
(buyItem 'notebook)