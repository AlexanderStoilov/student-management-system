import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'averageGradePrefixer'
})
export class AverageGradePrefixerPipe implements PipeTransform {

    transform(grade: number): string {
        return "avg. " + grade.toString();
    }

}
