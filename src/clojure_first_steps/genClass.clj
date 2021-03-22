(ns clojure-first-steps.genClass)

(gen-class
  :name genClass.MyClassGen
  :prefix "my-"
  :methods [[getName [] String]]
  :constructors {[String] []}
  :state state
  :init init
  )

(defn my-init
  [name]
  [[] {:name name}]
  )

(defn my-getName
  [this]
  (get (.state this) :name)
  )