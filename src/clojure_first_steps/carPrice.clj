(ns clojure-first-steps.carPrice)

(defn isCodeValid
  [code]
  (defstruct coupon :Name :Discount)
  (def validCoupon (struct coupon "20Percent" 0.8))
  (if (= (:Name validCoupon) code)
    true
    false
    )
  )

(defn getCarPrices
  [budget code]
  (def carsMap {"bmw" 60000, "ferrari" 100000, "fiat" 20000})
  (if (isCodeValid code)
    (do
      (println "The code is valid")
      ;access the variable of the function isCodeValid
      (def discount (:Discount validCoupon))
      (doseq [car carsMap]
        (def carType (first car))
        (def carPrice (last car))
        (def carPriceWithDiscount (* carPrice discount))
        (if (<= carPriceWithDiscount budget)
          (println "The" carType "costs" carPriceWithDiscount)
          )
        )
      )
    (do
      (println "The code is not valid")
      (doseq [car carsMap]
        (if (<= (last car) budget)
          (println "The" (first car) "costs" (last car))
          )
        )
      )
    )
  )
(getCarPrices 50000 "20Percent")
(getCarPrices 50000 "WrongCode")