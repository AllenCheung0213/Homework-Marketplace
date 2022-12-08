;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname gauro-s-cheung-a-hw3) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;;Allen Chueng and Sakshi Gauro
;;acheung and sgauro

;;Problem 1
(define-struct menu-item (name kind vegetarian? quantity cost))
;;a Menu-item is a (make-menu-item String String Boolean Natural Number)
;;interp: represents a menu-item where
;;name is the name if the item
;;kind is the type of item (appetizer, entree, dessert, or beverage)
;;vegetarian? is whether or not the item is vegeterian
;;quantity is the amount of the items ordered
;;cost id the cost of a single item

(define MOMO (make-menu-item "Mo:Mo" "appetizer" #false 5 9.8))
(define RICE (make-menu-item "Rice" "entree" #true 2 3.5))
(define MOCHI (make-menu-item "Mochi" "dessert" #true 7 8.75))
(define FRIES (make-menu-item "Fries" "appetizer" #true 10 7.5))
(define LASI (make-menu-item "Lasi" "beverage" #true 1 2.5))
(define PASTA (make-menu-item "pasta" "entree" #false 1 25))
(define SALAD (make-menu-item "salad" "appetizer" #true 5 8))
(define CAKE (make-menu-item "cake" "dessert" #false 1 12))
(define LEMONADE (make-menu-item "lemonade" "beverage" #true 1 3))
(define WATER (make-menu-item "water" "beverage" #true 1 1))
(define FISH+CHIPS (make-menu-item "fish+chips" "entree" #false 1 18))
(define BAKEDPOTATO (make-menu-item "bakedpotato" "appetizer" #true 4 5))
(define ICECREAM (make-menu-item "icecream" "dessert" #false 1 3))

;;Problem 2
; ;; menu-item-fcn:  Menu-item -> ...
; ;; 
; (define (menu-item-fcn a-menu-item)
;   (... (menu-item-name a-menu-item)
;        (menu-item-kind a-menu-item)
;        (menu-item-vegetarian? a-menu-item)
;        (menu-item-quantity a-menu-item)
;        (menu-item-cost a-menu-item)))

;;Problem 3
;;an Order (ListOfMenu-item) is one of
;;   empty
;;   (cons menu-item Order)
;; interp: Order is a ListOfMenu-item

(define PARTY1 (cons MOMO (cons RICE (cons MOCHI (cons LASI empty)))))
(define PARTY2 (cons MOCHI (cons LASI empty)))
(define WPI (cons MOMO (cons RICE (cons MOCHI (cons FRIES (cons LASI empty))))))
(define ME (cons RICE (cons LASI empty)))
(define HONO (cons FRIES (cons BAKEDPOTATO (cons PASTA (cons SALAD (cons LEMONADE empty))))))
(define ORDER1 (cons PASTA (cons SALAD (cons LEMONADE empty))))
(define ORDER2 (cons WATER (cons CAKE (cons FISH+CHIPS empty))))
(define ORDER3 (cons ICECREAM (cons CAKE (cons LEMONADE (cons ICECREAM (cons SALAD (cons LEMONADE empty)))))))

;;Problem 4
; ;; Order-fcn:  Order ->
; ;;
; (define (Order-fcn alomi)
;   (cond [(empty? alomi) empty]
;         [(cons? alomi)   (...        (menu-item-fcn (first alomi))
;                                     (Order-fcn (rest alomi)))]))

;;Problem 5
;;HELPER FUNCTION
;;SIGNATURE/PURPOSE
;;appetizer?: Menu-item -> Natural
;;consumes a Menu-item and if it is a appetizer, it produces a 1 and if it is not it produces a 0

;(define (appetizer? item) 0) ;stub

;(define (appetizer? item)   ;template
;  (...item)

(check-expect (appetizer? PASTA) 0)
(check-expect (appetizer? SALAD) 1)
(check-expect (appetizer? LASI) 0) 

(define (appetizer? item)
  (if (string=? (menu-item-kind item) "appetizer") 1 0))

;;SIGNATURE/PURPOSE
;;count-appetizers: Order -> Natural
;;consumes an order and returns the number of items in the order that are appetizers

(check-expect (count-appetizers PARTY1) 1)
(check-expect (count-appetizers PARTY2) 0)
(check-expect (count-appetizers empty) 0)

;(define (count-appetizers order) 0)       ;;STUB

;(define (count-appetizers order) ;template
;  (cond[(...)...]
;       [(... order) (...order)]))

(define (count-appetizers order)
  (cond[(empty? order) 0]
       [(cons? order) (+ (appetizer? (first order)) (count-appetizers (rest order)))]))

;;Problem 6
;;;HELPER FUNCTION
;;SIGNATURE/PURPOSE
;;cost-check: Menu-item Natural -> Boolean
;;consumes an Menu-item and a number to produces a true if the cost is more than the amount given

;(define (cost-check item num) #true) ;stub

;(define (cost-check item num)  ;template
;  (if(...item ...num)))

(check-expect (cost-check PASTA 30) #false)
(check-expect (cost-check SALAD 4) #true)
(check-expect (cost-check MOMO 4) #true)

(define (cost-check item num)
  (> (menu-item-cost item) num))

;;list-expensive-vegetarian: Order Natural -> Order
;;consumes an order and a number to produce a order that only contains vegetarian dishes and dishes that cost more than the number

;(define (list-expensive-vegetarian order num) empty) ;stub

;(define (list-expensive-vegetarian order num)  ;template
;  (cond[(empty?...) ...]
;       [(cons? ...) (...order...num)]))

(check-expect (list-expensive-vegetarian ORDER1 2) (cons SALAD (cons LEMONADE empty)))
(check-expect (list-expensive-vegetarian ORDER2 3) empty)
(check-expect (list-expensive-vegetarian PARTY2 1) (cons MOCHI (cons LASI empty)))

(define (list-expensive-vegetarian order num)
  (cond[(empty? order) empty]
       [(cons? order) (if (and (cost-check (first order) num) (menu-item-vegetarian? (first order)))
                          (cons (first order) (list-expensive-vegetarian (rest order) num))
                          (list-expensive-vegetarian (rest order) num))]))


;;Problem 7

;;;HELPER FUNCTION:
;;SIGNATURE/PURPOSE
;;menu-item-total: Menu-item -> Number
;;consumes a Menu-item and produces the total cost of the item

(check-expect (menu-item-total MOMO) 49)
(check-expect (menu-item-total RICE) 7)
(check-expect (menu-item-total MOCHI) 61.25)
(check-expect (menu-item-total FRIES) 75)
(check-expect (menu-item-total LASI) 2.5)

;(define (menu-item-total a-menu-item) 0)      ;STUB

; (define (menu-item-total a-menu-item)      ;TEMPLATE
;   (... (menu-item-quantity a-menu-item)
;        (menu-item-cost a-menu-item)))

(define (menu-item-total a-menu-item)
   (*  (menu-item-quantity a-menu-item)
        (menu-item-cost a-menu-item)))


;;SIGNATURE/PURPOSE
;;order-total: Order -> Number
;;consumes an order and produces the total cost of the order

(check-expect (order-total PARTY1) 119.75)
(check-expect (order-total ME) 9.5)
(check-expect (order-total empty) 0)

;(define (order-total order) 0)     ;STUB

;;(define (order-total alomi)
;   (cond [(empty? alomi) empty]
;         [(cons? alomi)   (...        (menu-item-total (first alomi))
;                                     (order-total (rest alomi)))]))

(define (order-total alomi)
   (cond [(empty? alomi) 0]
         [(cons? alomi)  (+ (menu-item-total (first alomi))
                                     (order-total (rest alomi)))]))

;;Problem 8

;;SIGNATURE/PURPOSE
;;isbeverage: Menu-item -> Boolean
;;consumes a menu-item to produce true if it is a beverage. False if it is not.

(check-expect (isbeverage LEMONADE) #true)
(check-expect (isbeverage MOCHI) #false)
(check-expect (isbeverage LASI) #true)

;(define (isbeverage item) #true) ;stub

;(define (isbeverage item)   ;template
;  (...item)

(define (isbeverage item)
  (string=? (menu-item-kind item) "beverage"))

;;SIGNATURE/PURPOSE
;;beverage-total: Order -> Number
;;consumes an order to produce the cost of all the beverages in the Order

;(define (beverage-total alomi) 0) ;stub

;(define (beverage-total alomi)   ;Template
;   (cond [(empty? alomi)  (...) ]
;         [(cons? alomi)   (...        (menu-item-fcn (first alomi))
;                                     (beverage-total (rest alomi)))]))

(check-expect (beverage-total ORDER1) 3)
(check-expect (beverage-total empty) 0)
(check-expect (beverage-total ORDER3) 6)

(define (beverage-total alomi)
   (cond [(empty? alomi)  0 ]
         [(cons? alomi)   (if (isbeverage(first alomi))
                              (+ (* (menu-item-quantity (first alomi)) (menu-item-cost (first alomi))) (beverage-total (rest alomi)))
                               (beverage-total (rest alomi)))]))

;;Problem 9

;;HELPER FUNCTION
;;SIGNATURE/PURPOSE
;;order-total-no-bev: Order -> Number
;;consumes an order and produces the total cost of the order without beverage

(check-expect (order-total-no-bev ORDER1) 65)
(check-expect (order-total-no-bev empty) 0)
(check-expect (order-total-no-bev ME) 7)

;(define (order-total-no-bev order) 0)     ;STUB

;(define (order-total-no-bev alomi)
;   (cond [(empty? alomi) empty]
;         [(cons? alomi)   (...        (isbeverage (first alomi))
;                                     (order-total-no-bev (rest alomi)))]))

(define (order-total-no-bev alomi)
   (cond [(empty? alomi) 0]
         [(cons? alomi)  (if (isbeverage (first alomi))(order-total-no-bev (rest alomi)) (+ (menu-item-total (first alomi))
                                     (order-total-no-bev (rest alomi))))]))

;;SIGNATURE/PURPOSE
;;total-with-tip: Number Number -> Number
;;consumes a number (cost of food) and another number (percent of tip) and produces the total with the tip.

(check-expect (total-with-tip 500 10) 550)
(check-expect (total-with-tip 0 0) 0)
(check-expect (total-with-tip 100 0) 100)

;((define (total-with-tip cost percent) 0) ;STUB

;(define (total-with-tip cost percent)    ;TEMPLATE
;  (... cost ... percent ))

(define (total-with-tip cost percent)
  (+ (* cost (/ percent 100)) cost))

;;SIGNATURE/PURPOSE
;;cost-with-tip: Order Number -> Number
;;consumes an order and a number (percent of the tip) and produces the total cost of the order with
;;the tip applied only to non-beverage items.

;(define (cost-with-tip order tip-percent) 0)    ;STUB

;(define (cost-with-tip alomi tip-percent)   ;Template
;   (cond [(empty? alomi)  (...) ]
;         [(cons? alomi)   (...        (menu-item-fcn (first alomi))
;                                     (cost-with-tip (rest alomi)))]))

(define (cost-with-tip alomi tip-percent)  
   (cond [(empty? alomi) 0]
         [(cons? alomi) (+ (total-with-tip (order-total-no-bev alomi) tip-percent) (beverage-total alomi))]))

(check-expect (cost-with-tip ORDER1 10) 74.5)
(check-expect (cost-with-tip empty 10) 0)
(check-expect (cost-with-tip ORDER1 0) 68)

