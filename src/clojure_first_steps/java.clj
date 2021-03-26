(ns clojure-first-steps.java
  (:import [java.util Date Calendar])
  )

;for System you don't need to import, because the package java.lang is already present on Clojure
;1616414461219
(println (System/currentTimeMillis))

;#inst "2021-03-22T12:07:07.800-00:00"
;putting a "." in front of the class you instantiate it
(println (Date.))

;#inst "2021-03-22T12:01:01.221-00:00"

;(System/currentTimeMillis) means the constructor
(println (Date. (System/currentTimeMillis)))

;1616414461223
;to call a method "." + instance + method name
(println (. (Date.) getTime))
;or
;1616414461224
(println (.getTime (Date.)))

;#inst "1986-12-22T09:02:17.738-02:00"
;doto exists because Clojure and Java are different in mutability
(println (doto (Calendar/getInstance)
           (.set Calendar/YEAR 1986)
           ;in java months is zero index
           (.set Calendar/MONTH 11)
           (.set Calendar/DAY_OF_MONTH 22)
           ))

;; Note that even though println returns nil, doto still returns the HashMap object
(doto (java.util.HashMap.)
  (.put "a" 1)
  (.put "b" 2)
  (println))
;;=> #<HashMap {b=2, a=1}>
;;=> {"b" 2, "a" 1}


;; careful when calling 'dotimes' from within a 'doto' statement
user=> (doto (java.util.ArrayList.)
         (.add -2)
         (.add -1)
         (dotimes [i 3] (.add i)))
;java.lang.IllegalArgumentException: dotimes requires a vector for its binding (NO_SOURCE_FILE:1)

; what has happened is that (java.util.ArrayList.) has secretly
; become the first argument to 'dotimes' and thus the exception
; informs us that it can't find the binding vector required for
; 'dotimes' to expand. You can cure this behaviour by simply using
; 'do' instead of 'doto' or by wrapping the call to 'dotimes' in
; a function. e.g:
do
;using 'let' with implicit 'do' instead of 'doto'
user=> (let [al (java.util.ArrayList.)]
         (.add al -2)
         (.add al -1)
         (dotimes [i 3] (.add al i))
         al);return the ArrayList
;#   ;exactly what we intended

    ;wrapping 'dotimes' in a function literal
    user=>(doto (java.util.ArrayList.)
            (.add -2)
            (.add -1)
            (#(dotimes [i 3] (.add % i))))
;#   ;exactly what we intended again


;create an array of objects with length 100
(object-array 100)

;Returns an array with components set to the values in aseq
(def myarray (into-array String ["this" "is" "an" "array"]))

;Returns the value at the index/indices. Works on Java arrays of all types
(aget myarray 1)
(aset myarray 1 "was")

;you can map over an array using a macro called amap
(amap myarray idx ret (aset ret idx (apply str (reverse (aget myarray idx)))))

;(areduce myarray idx ret (long 0) (+ ret (aget myarray idx)))


;Thread myththred = new Thread () {
;   public void run() {
;      System.out.println ("running")
;   }
;}
;proxy macro is a vector of classes and interfaces
(def mythread
  (proxy [Thread] []
    (run [] (println "running directly"))
    )
  )
(.run mythread)


(def mythreadWithinPool
  (proxy [Thread] []
    (run [] (println "running within a pool"))
    )
  )
;add a thread in a pool
(import 'java.util.concurrent.Executors)
(def mypool (Executors/newFixedThreadPool 4))
(.submit mypool mythreadWithinPool)

;execute a thread using runnable
(def myrunnable
  (proxy [Runnable] []
         (run [] (println "running within a pool with runnable"))
         )
  )
(.submit mypool myrunnable)

;reify is a macro with the following structure:  (reify options* specs*)
(def myreified
  (reify
    Comparable
    (compareTo [this other] -1)
    Runnable
    (run [this] (println "running via reify"))
    )
  )
(.submit mypool myreified)
(.compareTo myreified "Not myreified")

