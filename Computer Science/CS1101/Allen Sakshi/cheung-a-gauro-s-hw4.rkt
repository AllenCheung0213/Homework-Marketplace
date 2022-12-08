;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname cheung-a-gauro-s-hw4) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;;Allen Cheung & Sakshi Gauro
;;acheung  & sgauro


;;Problem 1:

(define-struct student (name email))
;;a Student is a (make-student String String)
;;interp: represents a person where
;; name is the name of the student
;;email-address is their email address

(define ANN (make-student "Ann Nomi" "anomi@wpi.edu"))
(define MARCUS (make-student "Marcus Hunter" "mhunter@wpi.edu"))
(define VANNY (make-student "Vanny Park" "vpark@wpi.edu"))
(define ADRIAN (make-student "Adrian Johnson" "ajohnson@wpi.edu"))
(define SAKSHI (make-student "Sakshi Gauro" "sgauro@wpi.edu"))
(define ALLEN (make-student "Allen Cheung" "acheung@wpi.edu"))
(define KARL (make-student "Karl Smith" "ksmith@wpi.edu"))
(define BOB (make-student "Bob Jones" "bjones@wpi.edi"))
(define JOE (make-student "Joe Hill" "jhill@wpi.edu"))
(define JOHN (make-student "John Cena" "jcena@wpi.edu"))
(define MATT (make-student "Matt Stick" "mstick@wpi.edu"))
(define TIM (make-student "Tim Bo" "tbo@wpi.edu"))
(define NICK (make-student "Nick John" "njohn@wpi.edu"))



;;a ListOfStudent is one of
;;    empty
;;   (cons student ListOfStudent)
;; interp: ListOfStudent is a ListOfStudent



(define CALC-I (cons ANN (cons MARCUS empty)))
(define CS (cons MARCUS (cons VANNY (cons SAKSHI (cons ALLEN (cons ADRIAN empty))))))
(define CALC-III (cons SAKSHI (cons ALLEN empty)))
(define PHY-I (cons ADRIAN (cons VANNY (cons SAKSHI empty))))
(define PHY-II (cons ALLEN (cons MARCUS (cons VANNY empty))))
(define STUDENTLIST1 (list KARL BOB JOE))
(define STUDENTLIST2 (list JOHN BOB))
(define STUDENTLIST3 (list MATT BOB JOE NICK JOHN))
(define STUDENTLIST4 (list JOHN BOB TIM))
(define STUDENTLIST5 (list MATT TIM NICK JOHN))

;; a BST is one of
;;   false
;;   CourseNode

(define-struct coursenode (course-id title instructor students left right))
;; a CourseNode is a (make-coursenode Number String String ListOfStudent BST BST)
;;interp: represents a CourseNode where
;;course-id is the unique course ID (the key value)
;;title is the title of the course
;;instructor is the name of the instructor
;;left is the left sub-tree of the CourseNode
;;right is the right sub-tree of the CourseNode
;;invariant: the course id of a node is greater than all the course id in its left subtree. The course id of a node is less than all
;;the course id in its right subtree.

;;Problem 2:

(define COMPUTERSCIENCE (make-coursenode 92.1101 "CS 1101" "Engling" CS #false #false))                               
(define MA1020 (make-coursenode 23.1020 "MA 1020" "Peng" CALC-I COMPUTERSCIENCE #false))
(define MA1023 (make-coursenode 23.1023 "MA 1023" "Dina" CALC-III PHY-II MA1020))
(define COURSE4 (make-coursenode 91.001 "Calculus 4" "Xavier Ramos Olivé" STUDENTLIST4 #false #false))
(define COURSE5 (make-coursenode 92.012 "The Great Problems Seminars" "Sean Kelly" STUDENTLIST5 #false #false))
(define COURSE3 (make-coursenode 92.312 "Object Oriented Design" "Joshua Cuneo" STUDENTLIST3 COURSE5 #false))
(define COURSE2 (make-coursenode 90.112 "Calculus 3" "John Goulet" STUDENTLIST2 #false COURSE4))
(define COURSE1 (make-coursenode 91.111 "Intro to Computer Science" "Michael Engling" STUDENTLIST1 COURSE2 COURSE3))


;;Problem 3:

;;;template for functions on Student:
;#;(define (fcn-for-student   a-student)
;  (... (student-name         a-student)
;       (student-email       a-student)))

;;Template for ListOfStudent
;;los-fcn: ListOfStudent ->
;;
;(define (los-fcn aloc)
;(cond [(empty? alos) (...)]
;      [(cons? alos) (...     (student-fcn (first alos))
;                             (los-fcn (rest alos)))]))
;

;;;(naive) template for functions on BST:
;#;(define (fcn-for-BST a-tree)
;    (cond [(boolean? a-tree) (... )];base case
;          [(coursenode?  a-tree) (... (coursenode-course-id a-tree)
;                                  (coursenode-title a-tree)
;                                  (coursenode-instructor a-tree)
;                                  (coursenode-students a-tree)
;                                  (coursenode-left a-tree)
;                                  (coursenode-right a-tree))]))
;

;;;(recursive) template for functions on BST:
;#;(define (fcn-for-BST a-tree)
;    (cond [(boolean? a-tree) (... )];base case
;          [(coursenode?  a-tree) (... (coursenode-course-id a-tree)
;                                  (coursenode-title a-tree)
;                                  (coursenode-instructor a-tree)
;                                  (coursenode-students a-tree)
;                                  (fcn-for-BST (coursenode-left a-tree))
;                                  (fcn-for-BST (coursenode-right a-tree)))]))


;;Problem 4:
;;SIGNATURE/PURPOSE
;;any-taught-by?: String BST -> Boolean
;;consumes the name of an instructor and a coursenode and produces true if any of the courses is taught by the instructor. False otherwise.

;(define (any-taught-by? bst instructor) false) ;stub

;(define (any-taught-by? bst instructor)  ;template
;    (cond [(boolean? bst) (... )];base case
;          [(coursenode?  bst) (...
;                                  (any-taught-by? (coursenode-left bst) instructor)
;                                  (any-taught-by? (coursenode-right bst) instructor))]))


(check-expect (any-taught-by? COURSE1 "Michael Engling") #true)
(check-expect (any-taught-by? COURSE1 "") #false)
(check-expect (any-taught-by? COURSE1 "Xavier Ramos Olivé") #true)
(check-expect (any-taught-by? COURSE2 "I'm tired") #false)


(define (any-taught-by? bst instructor)
  (cond [(boolean? bst) false];base case
        [(coursenode?  bst) (or (string=? (coursenode-instructor bst) instructor)
                                (any-taught-by? (coursenode-left bst) instructor)
                                (any-taught-by? (coursenode-right bst)instructor))]))

;;Problem 5:

;;SIGNATURE/PURPOSE
;;drop-student: BST Number String -> BST
;;consumes a binary search tree, a course number, and the email address of a student, and produces a binary search tree with
;;the student with the given email address removed from the list of students enrolled in the given course.

(check-expect (drop-student COURSE3 92.012 "mstick@wpi.edu")
              (make-coursenode
               92.312
               "Object Oriented Design"
               "Joshua Cuneo"
               (list (make-student "Matt Stick" "mstick@wpi.edu")
                     (make-student "Bob Jones" "bjones@wpi.edi")
                     (make-student "Joe Hill" "jhill@wpi.edu")
                     (make-student "Nick John" "njohn@wpi.edu")
                     (make-student "John Cena" "jcena@wpi.edu"))
               (make-coursenode
                92.012
                "The Great Problems Seminars"
                "Sean Kelly"                    
                (list (make-student "Tim Bo" "tbo@wpi.edu")
                      (make-student "Nick John" "njohn@wpi.edu")
                      (make-student "John Cena" "jcena@wpi.edu"))
                #false
                #false)
               #false))
(check-expect (drop-student MA1023 23.1023 "jhill@wpi.edu") MA1023)
(check-expect (drop-student #false 23.1023 "jhill@wpi.edu") #false)
(check-expect (drop-student COMPUTERSCIENCE 92.1101 "jhill@wpi.edu") COMPUTERSCIENCE)
(check-expect (drop-student COMPUTERSCIENCE 93.1101 "jhill@wpi.edu") COMPUTERSCIENCE)
          
;;(define (drop-student a-tree course-num email-address) COURSE5)     ;;STUB

  
(define (drop-student a-tree course-num email-address)
  (cond [(boolean? a-tree) #false];base case
        [(coursenode?  a-tree) (cond
                                 [(= course-num (coursenode-course-id a-tree)) (make-coursenode
                                                                                (coursenode-course-id a-tree)
                                                                                (coursenode-title a-tree)
                                                                                (coursenode-instructor a-tree)
                                                                                (remove-student (coursenode-students a-tree) email-address)
                                                                                (coursenode-left a-tree)
                                                                                (coursenode-right a-tree))]

                                 [(< course-num (coursenode-course-id a-tree)) (make-coursenode
                                                                                (coursenode-course-id a-tree)
                                                                                (coursenode-title a-tree)
                                                                                (coursenode-instructor a-tree)
                                                                                (coursenode-students a-tree)
                                                                                (drop-student (coursenode-left a-tree) course-num email-address)
                                                                                (coursenode-right a-tree))]
                                 
                                 [(> course-num (coursenode-course-id a-tree)) (make-coursenode
                                                                                (coursenode-course-id a-tree)
                                                                                (coursenode-title a-tree)
                                                                                (coursenode-instructor a-tree)
                                                                                (coursenode-students a-tree)
                                                                                (coursenode-left a-tree)
                                                                                (drop-student (coursenode-right a-tree) course-num email-address))])]))



;;;HELPER FUNCTION
;;SIGNATURE/PURPOSE
;;remove-student: ListOfStudent String -> ListOfStudent
;;consumes a ListOfStudent and returns a new ListOfStudent with the student with the email address removed.

(check-expect (remove-student empty "ajohnson@wpi.edu") empty)
(check-expect (remove-student empty "ajohnson@wpi.edu") empty)
(check-expect (remove-student STUDENTLIST4 "jcena@wpi.edu")
              (list (make-student "Bob Jones" "bjones@wpi.edi")
                    (make-student "Tim Bo" "tbo@wpi.edu")))
(check-expect (remove-student CALC-I "anomi@wpi.edu")
              (list (make-student "Marcus Hunter" "mhunter@wpi.edu")))

;;(define (remove-student alos email-address) empty)     ;;STUB

(define (remove-student alos email-address)
  (cond [(empty? alos) empty]
        [(cons? alos) (if (string=? email-address (student-email (first alos)))
                          (remove-student (rest alos) email-address)
                          (cons (first alos) (remove-student (rest alos) email-address)))]))

;;Problem 6:
;;SIGNATURE/PURPOSE
;;list-titles-in-order-by-coursenum: Coursenode -> ListOfString
;;consumes a binary search tree and produces a list of the titles of the courses, sorted in order by ascending course number
;(define (list-titles-in-order-by-coursenum bst) (list empty)) ;stub
;(define (list-titles-in-order-by-coursenum bst )  ;template
;    (cond [(boolean? bst) (... )];base case
;          [(coursenode?  bst) (...
;                                  (list-titles-in-order-by-coursenum (coursenode-left bst) instructor)
;                                  (list-titles-in-order-by-coursenum (coursenode-right bst) instructor))]))

(check-expect (list-titles-in-order-by-coursenum COURSE5) (list "The Great Problems Seminars"))
(check-expect (list-titles-in-order-by-coursenum COURSE3) (list "The Great Problems Seminars" "Object Oriented Design"))
(check-expect (list-titles-in-order-by-coursenum COURSE1) (list "Calculus 3" "Calculus 4" "Intro to Computer Science" "The Great Problems Seminars" "Object Oriented Design"))


(define (list-titles-in-order-by-coursenum bst)
  (cond [(boolean? bst) empty]
        [(and (coursenode?  bst) (not (boolean? (coursenode-left bst))))(if (< (coursenode-course-id bst) (coursenode-course-id(coursenode-left bst)))
                                                                            (append (list (coursenode-title bst)) (list (coursenode-title(coursenode-left bst))))
                                                                            (append (list-titles-in-order-by-coursenum (coursenode-left bst)) (list (coursenode-title bst))
                                                                                    (list-titles-in-order-by-coursenum (coursenode-right bst))))]
        [(coursenode?  bst) (append (list (coursenode-title bst))
                                    (list-titles-in-order-by-coursenum (coursenode-left bst))
                                    (list-titles-in-order-by-coursenum (coursenode-right bst)))]))


;;Problem 7:
;;SIGNATURE/PURPOSE
;;add-course: Coursenode Number String String -> Coursenode
;;consumes a binary search tree, a course number, a course title, and the name of the instructor,
;;and creates a binary search tree the same as the original except that a new course with the given information has been added to the tree
;;the course is created with an empty enrollment list.
;(define (add-course bst cnum ctitle cinstructor) (make-coursenode 0 "" "" empty false false)); stub
;(define (add-course bst cnum ctitle cinstructor)
;    (cond [(boolean? bst) (... )];base case
;          [(coursenode?  bst) (... (coursenode-course-id bst)
;                                  (coursenode-title bst)
;                                  (coursenode-instructor bst)
;                                  (coursenode-student bst)
;                                  (add-course (coursenode-left bst))
;                                  (add-course (coursenode-right bst)))]))

(check-expect (add-course COURSE5 92.102 "Tired" "Done") (make-coursenode 92.012 "The Great Problems Seminars" "Sean Kelly" STUDENTLIST5 #false (make-coursenode 92.102 "Tired" "Done" empty false false)))
(check-expect (add-course COURSE1 95.102 "Tired" "Done") (make-coursenode 91.111 "Intro to Computer Science" "Michael Engling" STUDENTLIST1 COURSE2
                                                                          (make-coursenode 92.312 "Object Oriented Design" "Joshua Cuneo" STUDENTLIST3 COURSE5 (make-coursenode 95.102 "Tired" "Done" empty false false))))
(check-expect (add-course COURSE1 90.102 "Tired" "Done") (make-coursenode 91.111 "Intro to Computer Science" "Michael Engling" STUDENTLIST1
                                                                          (make-coursenode 90.112 "Calculus 3" "John Goulet" STUDENTLIST2
                                                                                           (make-coursenode 90.102 "Tired" "Done" empty false false) COURSE4) COURSE3))

(define (add-course bst cnum ctitle cinstructor)
  (cond [(boolean? bst) (make-coursenode cnum
                                         ctitle
                                         cinstructor
                                         empty
                                         false
                                         false)];base case
        [(coursenode?    bst) (if (< cnum (coursenode-course-id bst))
                                  (make-coursenode
                                   (coursenode-course-id bst)
                                   (coursenode-title bst)
                                   (coursenode-instructor bst)
                                   (coursenode-students bst)
                                   (add-course (coursenode-left bst)
                                               cnum
                                               ctitle
                                               cinstructor)
                                   (coursenode-right bst))
                                  (make-coursenode
                                   (coursenode-course-id bst)
                                   (coursenode-title bst)
                                   (coursenode-instructor bst)
                                   (coursenode-students bst)
                                   (coursenode-left bst)
                                   (add-course (coursenode-right bst)
                                               cnum
                                               ctitle
                                               cinstructor)))]))
