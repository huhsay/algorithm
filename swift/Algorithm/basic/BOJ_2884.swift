//
//  BOJ_2884.swift
//  Algorithm
//
//  Created by Theodore's iMac on 2020/06/25.
//  Copyright © 2020 Sample. All rights reserved.
//

import Foundation

class BOJ_2884 {
    func solve() {
        let string = readLine()


        if let array = string?.components(separatedBy: " "){

            var h = Int(array[0])!
            var m = Int(array[1])!

            m = m - 45

            if ( m < 0) {
                h = h - 1
                m = 60 + m
            }
            
            if (h < 0) {
                h = 24 + h
            }

            print("\(h) \(m)")
        }
    }
}
