(ns clojure-first-steps.structMaps)

(defn pets
  []
  (defstruct pet :PetType :PetName)
  (def myPet (struct pet "dog" "Fido"))
  (println myPet)

  (def myOtherPet (struct-map pet :PetName "Fifi" :PetType "cat"))
  (println myOtherPet)

  (println (:PetName myPet))
  (println (:PetType myOtherPet))

  ;assoc change the field of the struct
  (def myNewPet (assoc myPet :PetName "Max"))
  (println myNewPet)
  ;you can ad a new field too
  (def myNewOtherPet (assoc myOtherPet :PetAge 10))
  (println myNewOtherPet)
  )
(pets)