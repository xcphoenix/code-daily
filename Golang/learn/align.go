package main

import (
	"fmt"
	"unsafe"
)

type Foo struct {
	one   [256]byte
	two   [256]byte
	three uint64
	four  uint64
}

func main() {
	f := &Foo{
		one: [256]byte{0},
		two: [256]byte{0},
	}
	fmt.Println(unsafe.Alignof(f.one))
	fmt.Println(unsafe.Alignof(f.two))
	fmt.Println(unsafe.Alignof(f.three))
	fmt.Println(unsafe.Alignof(f.four))
	fmt.Println(unsafe.Alignof(f))

	fmt.Println("Size:", unsafe.Sizeof(f))
}
