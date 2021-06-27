(defn square [x] (* x x))
(square 4)

(defn sumOfSquares [x y]
  (+ (square x) (square y)))

(sumOfSquares 4 4)

; cond
(defn abs1
  "return abs of x"
  [x]
  (cond
    (> x 0) x
    (= x 0) 0
    (< x 0) (- x)))

(abs1 -10)

; cond/else
(defn abs2
  [x]
  (cond
    (< x 0) (- x)
    :else x))

(abs2 10)

(defn abs3
  [x]
  (if
   (< x 0) (- x) x))

(abs3 3)

; exc. 1.3

(defn smallestOfThreeNumbers
  [a b c]
  (and
   (<= a b)
   (<= a c)))

(defn sumOfSquaresOfTwoLargest
  [a b c]
  (cond
    (smallestOfThreeNumbers a b c) (sumOfSquares b c)
    (smallestOfThreeNumbers b a c) (sumOfSquares a c)))

(sumOfSquaresOfTwoLargest 10 2 3)

; exc. 1.4

(defn aPlusAbsB
  [a b]
  ((if (> b 0) + -) a b))

(aPlusAbsB 10 10)
(aPlusAbsB -20 10)