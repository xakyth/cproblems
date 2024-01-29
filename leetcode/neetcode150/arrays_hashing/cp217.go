package main

import "fmt"

func containsDuplicate(nums []int) bool {
	setNums := make(map[int]struct{})
	for _, v := range nums {
		if _, ok := setNums[v]; ok {
			return true
		}
		setNums[v] = struct{}{}
	}
	return false
}

func main() {
	myArray := []int{1, 2, 3, 1}
	fmt.Println(containsDuplicate(myArray))
}
