(ns clojure-first-steps.defmethod)

;Creates and installs a new method of multimethod associated with dispatch-value.

(defmulti service-charge (fn [acct] [(account-level acct) (:tag acct)]))
(defmethod service-charge [::acc/Basic ::acc/Checking]   [_] 25)
(defmethod service-charge [::acc/Basic ::acc/Savings]    [_] 10)
(defmethod service-charge [::acc/Premium ::acc/Account] [_] 0)

;this example illustrates that the dispatch type
;does not have to be a symbol, but can be anything (in this case, it's a string)

(defmulti greeting
          (fn [x] (get x "language")))

;params is not used, so we could have used [_]
(defmethod greeting "English" [params]
  "Hello!")

(defmethod greeting "French" [params]
  "Bonjour!")

;then can use this like this:
(def english-map {"id" "1", "language" "English"})
(def french-map {"id" "2", "language" "French"})

=>(greeting english-map)
"Hello!"
=>(greeting french-map)
"Bonjour!"

;; Methods can be given a name.  Very useful in stack traces.
(defmethod foo "a" name-of-method [params] "was a")


(defmulti ticket-price :customer-status)

(defmethod ticket-price :student
  ;; Everything after the dispatch value is passed to fn.
  student-price
  [customer]
  10.0)

(defmethod ticket-price :professional
  professional-price
  [customer]
  650.0)



(defmulti encounter
          (fn [x y] [(:role x) (:role y)]))

(defmethod encounter [:manager :boss] [x y]
  :promise-unrealistic-deadlines)

(defmethod encounter [:manager :developer] [x y]
  :demand-overtime)

(defmethod encounter [:developer :developer] [x y]
  :complain-about-poor-management)

(encounter {:role :manager} {:role :boss})
=> :promise-unrealistic-deadlines

;In the example you're confused about, what's going on is that a function is being
; defined that takes two maps, x and y, and returns a vector containing the value
; of :role in x and the value of :role in y.
;The most confusing part of the second example is actually what is going on with
; defmulti. The fn in defmulti is used to define a dispatch function. The result
; of that function (the vector containing the role of x and the role of y) can be
; matched against by defmethod.
(defmethod encounter ["hero" "trash-mob"] [_ _] "The hero crushes the trash-mob.")
(defmethod encounter ["hero" "boss-mob"] [_ _] "The hero struggles but eventually triumphs.")
(defmethod encounter ["hero" "love-interest"] [_ _] "True love's kiss!")

(encounter {:role "hero"} {:role "boss-mob"}) => "The hero struggles but eventually triumphs."
