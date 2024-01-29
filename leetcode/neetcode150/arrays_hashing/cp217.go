package main

import "fmt"

func containsDuplicate(nums []int) bool {
	setNums := make(map[int]bool)
	for i := 0; i < len(nums); i++ {
		if setNums[nums[i]] {
			fmt.Println(setNums)
			return true
		}
		setNums[nums[i]] = true
	}
	return false
}

func main() {
	myArray := []int{1, 2, 3, 1}
	fmt.Println(containsDuplicate(myArray))
}
