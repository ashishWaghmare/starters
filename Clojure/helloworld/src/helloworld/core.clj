(ns helloworld.core
  (:gen-class))

(defn isPrime
  "Check if prime"
  [number]
  (loop [i 2 mc(int(Math/sqrt number))]
    (print number mc i (= 0 (mod number i)) "\n" )
    (if (< i mc)
      (recur (inc i) mc))
  )
)

(defn prime
  "Main function for generating prime"
  [count]
  (print (filter isPrime (range 100)) "Next \n")   
) 

(defn -main
  "I can say 'Hello World'."
  [& args]
  ( prime 10
  ))
