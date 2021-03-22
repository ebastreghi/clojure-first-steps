(ns clojure-first-steps.javaClass
  (:import (clojure_first_steps.java MyClass)))

(def myinstance (MyClass. "Edevar"))
(.getName myinstance)

