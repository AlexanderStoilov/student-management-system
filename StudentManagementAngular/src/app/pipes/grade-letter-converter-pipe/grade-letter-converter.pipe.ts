import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'gradeLetterConverter'
})
export class GradeLetterConverterPipe implements PipeTransform {

    transform(grade: number): string {
        let m_gradeScale0to4 = grade - 2;
        let m_gradePercentage = m_gradeScale0to4 * 25;
        if (m_gradePercentage >= 0 && m_gradePercentage <= 65) {
            return "F";
        }
        else if (m_gradePercentage <= 66) {
            return "D";
        }
        else if (m_gradePercentage <= 69) {
            return "D+";
        }
        else if (m_gradePercentage <= 72) {
            return "C-";
        }
        else if (m_gradePercentage <= 76) {
            return "C";
        }
        else if (m_gradePercentage <= 79) {
            return "C+";
        }
        else if (m_gradePercentage <= 82) {
            return "B-";
        }
        else if (m_gradePercentage <= 86) {
            return "B";
        }
        else if (m_gradePercentage <= 89) {
            return "B+";
        }
        else if (m_gradePercentage <= 92) {
            return "A-";
        }
        else if (m_gradePercentage <= 96) {
            return "A";
        }
        else if (m_gradePercentage <= 100) {
            return "A+";
        }
        else {
            alert("Invalid argument passed.");
        }
    }

}
