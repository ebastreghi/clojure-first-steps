(ns clojure-first-steps.agents)

(defn agents
  "sample of agent functinarity"
  []
  ;agent is async and atom is sync
  (def amount (agent 100))
  (println @amount)

  (send amount inc)
  (println @amount)
  (println "Some time must pass")
  (println @amount)

  (send amount inc)
  ;wait 1s
  (await-for 1000 amount)
  (println @amount)

  ;pritn if exist an error
  (println (agent-error amount))
  )
(agents)