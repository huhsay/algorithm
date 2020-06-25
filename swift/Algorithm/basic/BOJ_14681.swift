//
//  BOJ_14681.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/23.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_14681 {
    func solve() {
        let x = Int(readLine()!)!
        let y = Int(readLine()!)!
        
        if (x > 0 && y > 0) {
            print(1)
        } else if (x < 0 && y > 0) {
            print(2)
        } else if (x < 0 && y < 0) {
            print(3)
        } else if (x > 0 && y < 0) {
            print(4)
        }
    }
}
