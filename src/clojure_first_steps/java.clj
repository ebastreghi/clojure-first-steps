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

