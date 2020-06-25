//
//  BOJ_2739.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/25.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation


class BOJ_2739 {
    func solve() {
        let N = Int(readLine()!)

        if let n = N {
            for index in 1...9 {
                let mul = n * index
                print("\(n) * \(index) = \(mul)")
            }
        }
    }
}
