;; Simple examples

;; Expressions

(do
  1
  (println "123")
  3)

(when true
  (println "123")
  (+ 1 2 3)
  :no)

(let [x 11
      y (+ 1 x)
      z (+ 1 y x)]
  (+ x y z))

(loop [x 10
       acc 0]
  (if (pos? x)
    (do
      (println x acc)
      (recur (- x 1) (+ acc x)))
    acc))

;; Fibonacci

(let [N 7]
  (loop [i 0
         fib-i-1 0
         fib-i 1]
    (if (= i N)
      fib-i
      (recur (inc i) fib-i (+ fib-i-1 fib-i)))))

;; Functions

(defn f1 [x]
  (println "fa")
  (+ 1 x))

;; Optional args

(defn f2 [x & rest]
  (println x rest))

;; Many args

(defn f3
  ([] 0)
  ([x] 1)
  ([x y] 2))

(defn f4
  ([] 0)
  ([_] 1)
  ([_ _] 2))

(defn- f5
  "Documentation"
  [x]
  (+ 1 x))

(defn- f6 ^{:pre [(pos? x)]
            :post [(< % 20) (> % 10)]}
  [x]
  (* 2 x))

;; Fibonacii function

(defn fib [N]
  (case N
    0 0
    1 1
    (+ (fib (- N 1)) (fib (- N 2)))))

;; Short notation
;; #(inc %)
;; #(+ %1 %2)
;; (str %1 %&)

(apply + [1 2 3 4]) ;; or (reduce + 0 [1 2 3 4 5])

;; Composition
((comp str vec clojure.core/reverse) [1 2 3])

;; Partial
(defn g [x y z] (+ x y z))
(fn [z] (g 1 2 z))
((partial g 1 2 3))

;; Return argument
(identity 8)

;; Juxt
(map (juxt dec identity inc) [1 2 3])