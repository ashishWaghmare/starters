(ns helloworld.core
  (:gen-class))

(defn isPrime
  "Check if prime"
  [number]
  (loop [i 2 mc(int(Math/sqrt number))]
    (if (< number 2) false
      (if (> i mc)
        true
        (if (= 0 (mod number i)) 
        false
        (recur (inc i) mc))
      )
    )
  )
)

(defn smartMultiply [x] (fn [y] (* x y)))

(defn prime
  "Main function for generating prime"
  [count]
  (def x (get (split-at count (filter isPrime (range 50))) 0))
  (loop [i 1]
     (def pivot (nth x (- i 1)))
     (def muliplier (if (= i 1) 1 pivot )) 
     (println (concat [pivot] (map (smartMultiply muliplier) (rest x))))
     (if (< i count) (recur(inc i)))
  )
)

(defn -main
  "I can say 'Hello World'."
  [& args]
  ( prime 10
  ))
