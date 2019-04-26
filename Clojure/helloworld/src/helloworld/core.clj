(ns helloworld.core
  (:gen-class))

(defn isPrime
   "Check if prime"
 [number]
 
)

(defn prime
  "Main function for generating prime"
  [count]
  (print (filter isPrime (range 100)))   
)

(defn -main
  "I can say 'Hello World'."
  [& args]
  ( prime 10
  ))

