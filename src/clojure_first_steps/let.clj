(ns clojure-first-steps.let)

;(let [bindings*] exprs*)
;binding => binding-form init-expr
;Evaluates the exprs in a lexical context in which the symbols in
;the binding-forms are bound to their respective init-exprs or parts
;therein.


;; let is a Clojure special form, a fundamental building block of the language.
;;
;; In addition to parameters passed to functions, let provides a way to create
;; lexical bindings of data structures to symbols. The binding, and therefore
;; the ability to resolve the binding, is available only within the lexical
;; context of the let.
;;
;; let uses pairs in a vector for each binding you'd like to make and the value
;; of the let is the value of the last expression to be evaluated. let also
;; allows for destructuring which is a way to bind symbols to only part of a
;; collection.

;; A basic use for a let:
user=> (let [x 1]
         x)
1

;; Note that the binding for the symbol y won't exist outside of the let:
user=> (let [y 1]
         y)
1
user=> (prn y)
java.lang.Exception: Unable to resolve symbol: y in this context (NO_SOURCE_FILE:7)

;; Note that if you use def inside a let block, your interned variable is within
;; the current namespace and will appear OUTSIDE of the let block.
user=> (let [y 1]
         (def z y)
         y)
1
user=> z
1

;; Another valid use of let:
user=> (let [a 1 b 2]
         (+ a b))
3

;; The forms in the vector can be more complex (this example also uses
;; the thread macro):
user=> (let [c (+ 1 2)
             [d e] [5 6]]
         (-> (+ d e) (- c)))
8

;; The bindings for let need not match up (note the result is a numeric
;; type called a ratio):
user=> (let [[g h] [1 2 3]]
         (/ g h))
1/2

;; From http://clojure-examples.appspot.com/clojure.core/let with permission.


user=> (let [a (take 5 (range))
             {:keys [b c d] :or {d 10 b 20 c 30}} {:c 50 :d 100}
             [e f g & h] ["a" "b" "c" "d" "e"]
             _ (println "I was here!")
             foo 12
             bar (+ foo 100)]
         [a b c d e f g h foo bar])
I was here!
[(0 1 2 3 4) 20 50 100 "a" "b" "c" ("d" "e") 12 112]





; :as example
user=> (let [[x y :as my-point] [5 3]]
         (println x y)
         (println my-point))

5 3
[5 3]

; :as names the group you just destructured.

; equivalent to (and better than)

user=> (let [[x y] [5 3]
             my-point [x y]]
;...



;;; map destructuring, all features
user=>
(let [
      ;;Binding Map
      {:keys [k1 k2]        ;; bind vals with keyword keys
       :strs [s1 s2]        ;; bind vals with string keys
       :syms [sym1 sym2]    ;; bind vals with symbol keys
       :or {k2 :default-kw, ;; default values
            s2 :default-s,
            sym2 :default-sym}
       :as m}  ;; bind the entire map to `m`
      ;;Data
      {:k1 :keyword1, :k2 :keyword2,  ;; keyword keys
       "s1" :string1, "s2" :string2,  ;; string keys
       'sym1 :symbol1,                ;; symbol keys
       ;; 'sym2 :symbol2              ;; `sym2` will get default value
       }]
  [k1 k2 s1 s2 sym1 sym2 m])  ;; return value

[:keyword1, :keyword2,
 :string1, :string2,
 :symbol1, :default-sym, ;; key didn't exist, so got the default
 {'sym1 :symbol1, :k1 :keyword1, :k2 :keyword2,
  "s1" :string1, "s2" :string2}]

;; remember that vector and map destructuring can also be used with
;; other macros that bind variables, e.g. `for` and `doseq`




;;define F1Car record
(defrecord F1Car [team engine tyre oil])

;;build the constructor distructing a single map with options
(defn make-f1team [f1-team f1-engine {:keys [f1-tyre f1-oil] :as opts}]
  (let [{:keys [tyre oil]} opts]
    (map->F1Car {:team f1-team
                 :engine f1-engine
                 :tyre f1-tyre
                 :oil f1-oil})))

;;create a record
(def mclaren (make-f1team "RedBull" "Renault" {:f1-tyre"Pirelli" :f1-oil "Castrol"}))

;;retrieve values
(keys mclaren)
(vals mclaren)
(:team mclaren)
(:oil mclaren)

