#ifndef __STUDENT_H__
#define __STUDENT_H__

#include <string>

class Student{
private:
    std::string  m_name;
    int          m_age;
    float        m_chinese_score;
    float        m_math_score;
    float        m_english_score;

public:
    Student(std::string name, 
            int age, 
            float chinese_score,
            float math_score,
            float english_score)
    {
        m_age = age;
        m_name = name;
        m_chinese_score = chinese_score;
        m_math_score = math_score;
        m_english_score = english_score;
    };
    void show();

private:
    void CalculateScore(int &score);
};

#endif
