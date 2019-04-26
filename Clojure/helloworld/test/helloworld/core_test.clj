(ns helloworld.core-test
  (:require [clojure.test :refer :all]
            [helloworld.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest a-test
  (testing "2 is Prime."
    (is (isPrime 2 ) true)))

(deftest a-test
  (testing "3 is Prime."
    (is (isPrime 3 )true)))

(deftest a-test
  (testing "4 is not Prime."
    (is (isPrime 4 )false)))

